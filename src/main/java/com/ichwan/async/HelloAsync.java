package com.ichwan.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class HelloAsync {

    @Async
    @SneakyThrows
    public void hello(){
        Thread.sleep(4000L);
        log.info("hello async {} ", Thread.currentThread());
    }
}
