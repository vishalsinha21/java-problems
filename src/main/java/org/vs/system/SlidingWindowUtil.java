package org.vs.system;

import java.time.LocalDateTime;

public class SlidingWindowUtil {


    public static SlidingWindow getMinuteSlidingWindow() {
        LocalDateTime from = LocalDateTime.now().withSecond(0).withNano(0);
        LocalDateTime to = LocalDateTime.now().withSecond(59).withNano(999999999);

        return new SlidingWindow(from, to);
    }

    public static SlidingWindow getHourSlidingWindow() {
        LocalDateTime from = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        LocalDateTime to = LocalDateTime.now().withMinute(59).withSecond(59).withNano(999999999);

        return new SlidingWindow(from, to);
    }

    public static SlidingWindow get24HourSlidingWindow() {
        LocalDateTime from = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime to = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        return new SlidingWindow(from, to);
    }

}
