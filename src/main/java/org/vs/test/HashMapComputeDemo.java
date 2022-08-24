package org.vs.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class HashMapComputeDemo {

    public static void main(String[] args) {
        computeIfPresentDemo();
    }

    //computeIfAbsent -> do if key is absent
    private static void computeIfAbsentDemo() {
        Map<String, String> map = new HashMap<>();

        map.computeIfAbsent("one", k -> "one");
        map.computeIfAbsent("two", k -> "two");
        map.computeIfAbsent("three", k -> "three");
        System.out.println(map); // one, two, three

        map.computeIfAbsent("six", k -> null);
        System.out.println(map); // no change

        map.computeIfAbsent("one", k -> "one again");
        System.out.println(map); //no change, as key is present
    }

    //computeIfPresent -> do if key is present
    private static void computeIfPresentDemo() {
        Map<String, Integer> map = new HashMap();

        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        map.put("d", 1);
        map.put("e", 1);
        System.out.println(map); //a, b, c, d, e

        map.compute("a", (k, v) -> v + 1); //increment value for a if present
        map.compute("b", (k, v) -> v + 1); //increment value for b if present
        System.out.println(map);

        map.computeIfPresent("f", (k, v) -> v + 1);
        System.out.println(map); //no change, since f is not present
    }

    //compute -> basically can support both computeIfAbsent and computeIfPresent
    private static void computeDemo(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Long> map = new HashMap<>();

        IntStream.range(0, chars.length)
                .mapToObj(i -> Character.valueOf(chars[i]))
                .forEach(ch -> map.compute(ch, (k, v) -> v == null ? 1 : map.get(k) + 1)); //if value is null then add 1 else, increment old value

        System.out.println(map);
    }

    private static void mergeDemo(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Long> map = new HashMap<>();

        IntStream.range(0, chars.length)
                .mapToObj(i -> Character.valueOf(chars[i]))
                .forEach(ch -> map.merge(ch, 1L, (oldValue, value) -> oldValue + 1)); //if value is null then add 1 else, increment old value

        System.out.println(map);
    }

}
