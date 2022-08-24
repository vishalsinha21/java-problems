package org.vs.ctci;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;

public class Test {

    public static void main(String[] args) {
        System.out.println(getCharMap("helloooo"));
    }

    public static Map<Character, Long> getCharMap(String str) {
        char[] chars = str.toCharArray();
        return IntStream.range(0, chars.length)
                .mapToObj(i -> Character.valueOf(chars[i]))
                .collect(Collectors.groupingBy(Function.identity(), counting()));
    }
}
