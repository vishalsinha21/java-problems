package org.vs.ctci.string.permutation;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println(str + ": " + isPermutationPerfectPalindrome(str));
    }

    public static boolean isPermutationPerfectPalindrome(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (ch != ' ') {
                if (map.containsKey(ch)) {
                    Integer value = map.get(ch);
                    map.put(ch, ++value);
                } else {
                    map.put(ch, 1);
                }
            }
        }

        int oddCount = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddCount++;
            }

            if (oddCount > 1) {
                return false;
            }
        }

        return true;
    }
}
