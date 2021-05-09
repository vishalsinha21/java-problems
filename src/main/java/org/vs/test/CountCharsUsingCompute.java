package org.vs.test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.valueOf;

public class CountCharsUsingCompute {

    public static void main(String[] args) {
        String str = "aaabbcdddd";
        Map<Character, Integer> map = new HashMap<>();


        str.chars()
                .forEach(c -> map.compute(
                        valueOf((char) c),
                        (key, value) -> value == null ? 1 : value + 1));


        System.out.println(map);
    }
}
