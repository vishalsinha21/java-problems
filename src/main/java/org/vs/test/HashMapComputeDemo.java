package org.vs.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapComputeDemo {

    public static void main(String[] args) {
        computeIfAbsentDemo();
    }

    private static void computeIfAbsentDemo() {
        Map<String, String> map = new HashMap<>();

        map.put("one", "one");
        map.put("two", "two");
        map.put("three", "three");
        map.put("six", null);

        map.computeIfAbsent("four", k -> "four"); //this will add four
        System.out.println(map);

        map.computeIfAbsent("five", k -> null); //mapping function returns null so it won't add five
        System.out.println(map);

        map.computeIfAbsent("one", k -> "1"); //key if already present in map so it won't change anything
        System.out.println(map);

        map.computeIfAbsent("six", k -> "six"); //key present with null value in map, so will be replaced
        System.out.println(map);
    }

    private static void computeDemo() {
        Map<String, Integer> map = new HashMap();

        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        map.put("d", 1);
        map.put("e", 1);
        System.out.println(map);

        map.compute("a", (k, v) -> v + 1);
        map.compute("b", (k, v) -> v + 1);
        System.out.println(map);

        map.computeIfPresent("a", (k, v) -> v + 1);
        System.out.println(map);

        map.computeIfAbsent("a", (k) -> 1);
        System.out.println(map);

        map.computeIfAbsent("f", (k) -> 1);
        System.out.println(map);
    }
}
