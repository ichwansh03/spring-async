package com.ichwan.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class Job {

    private AtomicLong atomicLong = new AtomicLong(0);

    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 3, fixedDelay = 2)
    public void job() {
        Long value = atomicLong.incrementAndGet();
        log.info("job value: {}", value);
    }

    public Long getAtomicLong() {
        return atomicLong.get();
    }

    @Scheduled(cron = "*/2 * * * * *")
    public void cronJob() {
        log.info("run cron job");
    }
}
