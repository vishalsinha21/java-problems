package org.vs.hackerrank.string;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;

public class SherlockString {

    public static void main(String[] args) {
        System.out.println(isValid2("aaaabbcc"));
    }

    public static String isValid(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        Map<Character, Long> map = IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i])
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));

        long[] values = map.values().stream().mapToLong(i -> i).toArray();

        long diffCount = 0;
        long diff = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != values[0]) {
                diffCount++;
                diff = Math.abs(values[i] - values[0]);

                if (diffCount > 1 || diff > 1) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static String isValid2(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        Map<Character, Long> map = IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long[] freqCount = map.values().stream().mapToLong(i -> i).toArray();

        Map<Long, Long> freqCountMap = IntStream.range(0, freqCount.length)
                .mapToObj(i -> freqCount[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (freqCountMap.size() == 1) {
            return "YES";
        }

        if (freqCountMap.size() > 2) {
            return "NO";
        }

        if (freqCountMap.size() == 2) {
            long[] values = freqCountMap.values().stream().mapToLong(i -> i).toArray();
            long[] keys = freqCountMap.keySet().stream().mapToLong(i -> i).toArray();

            if ((values[0] == 1 || values[1] == 1) && Math.abs(keys[0] - keys[1]) <= 1) {
                return "YES";
            } else {
                return "NO";
            }
        }

        return "YES";
    }
}
