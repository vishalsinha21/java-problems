package org.vs.system;

import java.time.LocalDateTime;
import java.util.Objects;

public class SlidingWindow {

    private LocalDateTime from;
    private LocalDateTime to;

    public SlidingWindow(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlidingWindow that = (SlidingWindow) o;
        return from.isEqual(that.from) && to.isEqual(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
