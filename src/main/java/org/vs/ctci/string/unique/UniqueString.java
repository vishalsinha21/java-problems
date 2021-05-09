package org.vs.ctci.string.unique;

import java.util.HashMap;
import java.util.Map;

public class UniqueString {

    public static void main(String[] args) {
        String str = "abcdghfghbsdsbsdfg";
        System.out.println(isUnique1(str));
    }

    public static boolean isUnique1(String str) {

        if (str.length() > 26) {
            return false;
        }

        char[] chars = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : chars) {
            if (map.containsKey(ch)) {
                return false;
            }
            map.put(ch, 1);
        }

        return true;
    }

    public static boolean isUnique2(String str) {
        boolean[] charOccurence = new boolean[128];

        if (str.length() > 128) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            int charIndex = str.charAt(i);

            if(charOccurence[charIndex] == true) {
                return false;
            }

            charOccurence[charIndex] = true;
        }

        return true;
    }

}
