package org.vs.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapComputeDemo {

    public static void main(String[] args) {
        computeDemo();
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
