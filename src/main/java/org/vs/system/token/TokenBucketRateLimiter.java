package org.vs.system.token;

import java.time.Duration;
import java.time.LocalDateTime;

public class TokenBucketRateLimiter {

    private long maxTokenPerMinute;
    private long refillRateTokenPerMinute;

    private long currentTokenCount;
    private LocalDateTime lastRefillTime;

    public TokenBucketRateLimiter(long maxTokenPerMinute, long refillRateTokenPerMinute) {
        this.maxTokenPerMinute = maxTokenPerMinute;
        this.refillRateTokenPerMinute = refillRateTokenPerMinute;
        this.currentTokenCount = maxTokenPerMinute;
        this.lastRefillTime = LocalDateTime.now();
    }

    public synchronized boolean isRequestAllowed(long token) {
        refill();

        if (currentTokenCount >= token) {
            currentTokenCount = currentTokenCount - token;
            return true;
        }

        return false;
    }

    private void refill() {
        Duration duration = Duration.between(lastRefillTime, LocalDateTime.now());
        if (duration.toSeconds() > 60) {
            currentTokenCount = maxTokenPerMinute;
            lastRefillTime = LocalDateTime.now();
        } else {
            long tokensToAdd = (refillRateTokenPerMinute * duration.toSeconds()) / 60;
            if (tokensToAdd > 0 && currentTokenCount < maxTokenPerMinute) {
                currentTokenCount = Math.min(maxTokenPerMinute, currentTokenCount + tokensToAdd);
                lastRefillTime = LocalDateTime.now();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(5, 5);
        for (int i = 0; i < 100; i++) {
            System.out.println(LocalDateTime.now() + "::" + rateLimiter.isRequestAllowed(1));
            Thread.sleep(1000);
        }
    }
}
