package org.vs.ctci.string.permutation;

import java.util.HashMap;
import java.util.Map;

public class Permutation {

    public static void main(String[] args) {
        System.out.println(checkPermutation("a", "a"));
        System.out.println(checkPermutation("a", "b"));
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation("abc", "bcca"));
        System.out.println(checkPermutation("abcde", "eabdc"));
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = getCharMap(str1);
        Map<Character, Integer> map2 = getCharMap(str2);

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            if (!(map2.get(key) == entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    public static Map<Character, Integer> getCharMap(String str) {
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                Integer value = map.get(str.charAt(i));
                map.put(str.charAt(i), ++value);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        return map;
    }
}
