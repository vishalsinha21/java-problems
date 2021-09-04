package org.vs.ctci.string;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abc", "bac")); //true
        System.out.println(isAnagram("abaa", "aaab")); //true
        System.out.println(isAnagram("abb", "baa")); //false
    }

    public static boolean isAnagram(String str1, String str2) {
        //check that strings should be not null and length of strings shouldbe equal
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        //Create a map of character frequency for each string
        Map<Character, Long> map1 = IntStream.range(0, chars1.length).mapToObj(i -> chars1[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> map2 = IntStream.range(0, chars2.length).mapToObj(i -> chars2[i])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //if map size differs then there is no point in checking further
        if (map1.size() != map2.size()) {
            return false;
        }

        //iterate over keys of map1 and check that map2 has the key present and even the value (character frequency is same)
        Optional<Character> result = map1.keySet().stream()
                .filter(k -> !(map2.containsKey(k) && map2.get(k) == map1.get(k)))
                .findFirst();

        //return true if result is empty else not
        return result.isEmpty();
    }


    public static boolean areAnagrams(String str1, String str2) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];

        int length1 = str1.length();
        int length2 = str2.length();

        if (length1 != length2) {
            return false;
        }

        for (int i = 0; i < length1; i++) {
            count1[str1.charAt(i)]++;
            count2[str2.charAt(i)]++;
        }

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }


}
