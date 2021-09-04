package org.vs.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UtilFunctions {

    //Check if 2 string has any common character
    public static String hasCommonSubString(String s1, String s2) {
        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            return "NO";
        }

        char[] s1chars = s1.toCharArray();
        Map<Character, Long> map = IntStream.range(0, s1chars.length)
                .mapToObj(i -> s1chars[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        char[] s2chars = s2.toCharArray();
        Optional<Character> result = IntStream.range(0, s2chars.length)
                .mapToObj(i -> s2chars[i])
                .filter(map::containsKey)
                .findFirst();

        return result.isPresent() ? "YES" : "NO";
    }

    public static List<String> arrayToList(String[] strArr) {
        List<String> list = Arrays.stream(strArr).collect(Collectors.toList());
        return list;
    }

    public static String sortStringCharacters1(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String sortStringCharacters2(String str) {
        return Stream.of(str.split("")).sorted().collect(Collectors.joining());
    }

    public static void main(String[] args) {
    }
}
