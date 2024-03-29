package com.ichwan.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void hello() {
        for (int i = 0; i < 10; i++) {
            helloAsync.hello();
        }
      log.info("after call hello()");
    }
}