package org.vs.system;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {

    private RateLimit rateLimit;
    private Map<SlidingWindow, AtomicInteger> slidingWindowCountMap;

    public RateLimiter(RateLimit rateLimit) {
        this.rateLimit = rateLimit;
        slidingWindowCountMap = new WeakHashMap<>();
    }

    public boolean isAllowed() {
        if (rateLimit.getRateLimitPerMinute().isPresent()) {
            return isAllowedPerMinute();
        }

        if (rateLimit.getRateLimitPerHour().isPresent()) {
            return isAllowedPerHour();
        }

        if (rateLimit.getRateLimitPerDay().isPresent()) {
            return isAllowedPerDay();
        }

        return true;
    }

    private boolean isAllowedPerDay() {
        SlidingWindow slidingWindow = SlidingWindowUtil.get24HourSlidingWindow();
        slidingWindowCountMap.putIfAbsent(slidingWindow, new AtomicInteger(0));

        AtomicInteger count = slidingWindowCountMap.get(slidingWindow);

        if (count.intValue() < rateLimit.getRateLimitPerMinute().get()) {
            count.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    private boolean isAllowedPerHour() {
        SlidingWindow slidingWindow = SlidingWindowUtil.getHourSlidingWindow();
        slidingWindowCountMap.putIfAbsent(slidingWindow, new AtomicInteger(0));

        AtomicInteger count = slidingWindowCountMap.get(slidingWindow);

        if (count.intValue() < rateLimit.getRateLimitPerMinute().get()) {
            count.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    private boolean isAllowedPerMinute() {
        SlidingWindow slidingWindow = SlidingWindowUtil.getMinuteSlidingWindow();
        slidingWindowCountMap.putIfAbsent(slidingWindow, new AtomicInteger(0));

        AtomicInteger count = slidingWindowCountMap.get(slidingWindow);

        if (count.intValue() < rateLimit.getRateLimitPerMinute().get()) {
            count.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimit rateLimit = RateLimit.getBuilder()
                .withRateLimitPerMinute(3)
                .withRateLimitPerHour(10)
                .withRateLimitPerDay(500).build();

        RateLimiter rateLimiter = new RateLimiter(rateLimit);

        for (int i = 0; i < 100; i++) {
            Thread.sleep(5000);
            System.out.println(LocalDateTime.now() + ": " + rateLimiter.isAllowed());
        }
    }
}
