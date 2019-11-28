package org.go.day1_1.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TimeMapperTests
 */
@SpringBootTest
public class TimeMapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testNow() {
        System.out.println("timeMapper: " + timeMapper.getTime());
    }

}