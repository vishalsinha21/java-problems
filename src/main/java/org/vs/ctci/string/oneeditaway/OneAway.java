package org.vs.ctci.string.oneeditaway;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneAway {

    //"pale", "pales"
    public static boolean isOneAway(String one, String two) {
        if (one == null || two == null || one.equals(two)) {
            return false;
        }

        if (Math.abs(one.length() - two.length()) > 1) {
            return false;
        }


        int[] arr = new int[26];

        for (char c : one.toCharArray()) {
            arr[getIndex(c)]++;
        }

        for (char c : two.toCharArray()) {
            arr[getIndex(c)]--;
        }

        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            diff += Math.abs(arr[i]);
        }

        if (diff > 2) {
            return false;
        }

        return true;
    }

    private static int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return -1;
    }

    private static Map<Character, Long> getCharMap(char[] chars) {
        Stream<Character> characterStream = IntStream.range(0, chars.length).mapToObj(i -> chars[i]);
        return characterStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
