package com.ichwan.async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobTest {

    @Autowired
    private Job job;

    @Test
    void runJobTest() throws InterruptedException {
        Thread.sleep(9000);
        assertEquals(4L, job.getAtomicLong());
    }
}