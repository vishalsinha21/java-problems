package org.vs.hackerrank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    public static void main(String[] args) {
        timeConversion("12:00:00AM");
    }

    public static String timeConversion(String s) {
        CharSequence timeStr = s.substring(0, 8);
        CharSequence ampmStr = s.substring(8, 10);

        LocalTime time = LocalTime.parse(timeStr);
        LocalTime result = time;

        if ("PM".equals(ampmStr) && time.getHour() != 12) {
            result = time.plusHours(12);
        }
        if ("AM".equals(ampmStr) && time.getHour() == 12) {
            result = time.minusHours(12);
        }

        System.out.println(result.format(DateTimeFormatter.ISO_TIME));
        return result.format(DateTimeFormatter.ISO_TIME);
    }

}
