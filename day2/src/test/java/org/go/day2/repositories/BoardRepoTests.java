package org.go.day2.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.go.day2.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import lombok.extern.slf4j.Slf4j;

/**
 * BoardRepoTests
 */

 @SpringBootTest
 @Slf4j  
public class BoardRepoTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.range(1, 101).forEach(i -> {
            Board board = new Board();
            board.setTitle("Sample Title");
            board.setContent("Content...."  + i);
            log.info(""  + boardRepository.save(board));
        });
    }

    @Test
    public void testReadAndUpdate() {
        Optional<Board> result = boardRepository.findById(99);
        log.info("" + result);
        if (result.isPresent()) {
            Board board = result.get();
            board.setTitle(("Update Title...."));
            // save - entity, flush - db
            // db와 동기화
            boardRepository.save(board);
        }
    }

    @Test
    public void testPaging() {

        // page 0부터 시작
        Pageable page = PageRequest.of(0, 10, Direction.DESC, "bno");

        Page<Board> result = boardRepository.findAll(page);

        // linkedList
        log.info("" + result.getPageable());
        log.info("" + result.getTotalPages());

        Stream<Board> stream = result.get();
        List<Board> list = stream.collect(Collectors.toList());
        list.forEach(i -> {
            log.info(""+ i);
        });

    }

    @Test
    public void testSearch() {
        Pageable page = PageRequest.of(0, 10, Direction.DESC, "bno");

        Page<Board> result = boardRepository.findByTitleContaining("update", page);

        log.info("" + result);

        log.info("" + result.getPageable());
        log.info("" + result.getTotalPages());

        Stream<Board> stream = result.get();
        List<Board> list = stream.collect(Collectors.toList());
        list.forEach(i -> {
            log.info(""+ i);
        });
    }
}