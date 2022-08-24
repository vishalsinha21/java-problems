package org.vs.practice.string;

import java.util.*;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtils {

    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        if (str1.equals(str2)) {
            return true;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Map<Character, Long> map1 = IntStream.range(0, chars1.length).mapToObj(i -> Character.valueOf(chars1[i]))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> map2 = IntStream.range(0, chars2.length).mapToObj(i -> Character.valueOf(chars2[i]))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || map1.get(key) != map2.get(key)) {
                return false;
            }
        }

        Optional<Character> result = map1.keySet().stream()
                .filter(key -> !(map2.containsKey(key) && map2.get(key) == map1.get(key)))
                .findFirst();

        return result.isEmpty();
    }
}
