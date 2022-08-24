package org.vs.system;

import java.util.Optional;

public class RateLimit {

    private Optional<Integer> rateLimitPerMinute;
    private Optional<Integer> rateLimitPerHour;
    private Optional<Integer> rateLimitPerDay;

    public RateLimit(Optional<Integer> rateLimitPerMinute, Optional<Integer> rateLimitPerHour, Optional<Integer> rateLimitPerDay) {
        this.rateLimitPerMinute = rateLimitPerMinute;
        this.rateLimitPerHour = rateLimitPerHour;
        this.rateLimitPerDay = rateLimitPerDay;
    }

    public static RateLimitBuilder getBuilder() {
        return new RateLimitBuilder();
    }

    public Optional<Integer> getRateLimitPerMinute() {
        return rateLimitPerMinute;
    }

    public Optional<Integer> getRateLimitPerHour() {
        return rateLimitPerHour;
    }

    public Optional<Integer> getRateLimitPerDay() {
        return rateLimitPerDay;
    }

    public static class RateLimitBuilder {
        private Optional<Integer> rateLimitPerMinute;
        private Optional<Integer> rateLimitPerHour;
        private Optional<Integer> rateLimitPerDay;

        public RateLimitBuilder withRateLimitPerMinute(Integer rateLimitPerMinute) {
            this.rateLimitPerMinute = Optional.of(rateLimitPerMinute);
            return this;
        }

        public RateLimitBuilder withRateLimitPerHour(Integer rateLimitPerHour) {
            this.rateLimitPerHour = Optional.of(rateLimitPerHour);
            return this;
        }

        public RateLimitBuilder withRateLimitPerDay(Integer rateLimitPerDay) {
            this.rateLimitPerDay = Optional.of(rateLimitPerDay);
            return this;
        }

        public RateLimit build() {
            return new RateLimit(this.rateLimitPerMinute, this.rateLimitPerHour, this.rateLimitPerDay);
        }
    }
}
