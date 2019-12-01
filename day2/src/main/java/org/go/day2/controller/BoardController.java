package org.go.day2.controller;

import org.go.day2.domain.Board;
import org.go.day2.dto.SearchDTO;
import org.go.day2.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * BoardController
 */
@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Setter(onMethod_ = @Autowired)
    private BoardRepository boardRepository;
    
    @GetMapping("/{bno}")
    public ResponseEntity<Board> read(@PathVariable("bno") Integer bno) {
        
        log.info("" +bno);

        return new ResponseEntity<>(boardRepository.findById(bno).get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Board> register(@RequestBody Board board) {
        log.info("" + board);

        Board result = boardRepository.save(board);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<MultiValueMap<String, Object>> getList(
        @SortDefault(sort = "bno", direction = Direction.DESC) Pageable page, SearchDTO searchDTO) {
            
            log.info("" + page);
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            map.add("search", searchDTO);
            Page<Board> result = boardRepository.findAll(page);
            map.add("result", result);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    
}