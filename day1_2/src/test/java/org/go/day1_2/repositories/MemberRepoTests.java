package org.go.day1_2.repositories;

import java.util.Optional;
import java.util.stream.IntStream;

import org.go.day1_2.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import lombok.extern.slf4j.Slf4j;

/**
 * MemberRepoTests
 */
@SpringBootTest
@Slf4j
public class MemberRepoTests {

    @Autowired
    private MemberRepository memberRepository;

    // 테이블 생성 확인
    @Test
    public void test1(){
        log.info("test1..........................");
        log.info("test1..........................");
        log.info("test1..........................");
    }

    // 입력 테스트
    @Test
    public void testInsert() {

        IntStream.range(1, 101).forEach(i -> {

            Member member = 
            Member.builder().mid("user" + i).mpw("pw").mname("사용자" + i).build();

            log.info("=====================================");

            // insert
            log.info("" + memberRepository.save(member));

        });
    }

    // 조회 테스트
    @Test
    public void testRead() {

        // findById Optional 객체 반환
        Optional<Member> result = memberRepository.findById("user7");

        log.info("" + result.get());
    }

    // 페이징 테스트
    @Test
    public void testPaging() {

        Pageable page = 
        PageRequest.of(2, 10, Direction.DESC, "mid");

        Page<Member> result = memberRepository.findAll(page);

        log.info("" + result.getTotalPages());

        result.forEach(m -> log.info("" + m));
    }
}