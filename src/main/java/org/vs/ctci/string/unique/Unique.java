package org.vs.ctci.string.unique;

import java.util.HashMap;
import java.util.Map;

public class Unique {

    public static void main(String[] args) {
        String str = "abcdefghi";

        System.out.println(isUnique(str));
        System.out.println(isUnique2(str));
    }

    private static boolean isUnique(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                return false;
            }
            map.put(str.charAt(i), 1);
        }

        return true;
    }

    private static boolean isUnique2(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch, i + 1) != -1) {
                return false;
            }
        }

        return true;
    }
}
