package org.vs.hackerrank.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SherlockAnagrams {

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public static int sherlockAndAnagrams(String s) {
        int length = s.length();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i < length; i++) {
            for (int j = 0; i + j <= length; j++) {
                char[] chars = s.substring(j, i + j).toCharArray();
                Arrays.sort(chars);
                String sortedString = new String(chars);

                if (map.containsKey(sortedString)) {
                    map.put(sortedString, map.get(sortedString) + 1);
                } else {
                    map.put(sortedString, 1);
                }
            }
        }

        return map.values().stream()
                .filter(i -> i > 1)
                .mapToInt(i -> getCombinationNc2(i))
                .sum();
    }


    private static int getCombinationNc2(int n) {
        return (n * (n - 1))/2;
    }
}
