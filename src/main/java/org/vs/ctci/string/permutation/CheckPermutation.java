package org.vs.ctci.string.permutation;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(checkPermutation("a", "a"));
        System.out.println(checkPermutation("ab", "ba"));
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation("abb", "aab"));
        System.out.println(checkPermutation("abbb", "babb"));
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str1.length()) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : str1.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (Character c : str2.toCharArray()) {
            if (charMap.containsKey(c) && charMap.get(c) > 0) {
                charMap.put(c, charMap.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

}
