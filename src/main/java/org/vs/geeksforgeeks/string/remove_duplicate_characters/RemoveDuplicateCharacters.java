package org.vs.geeksforgeeks.string.remove_duplicate_characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//URL: https://practice.geeksforgeeks.org/problems/remove-duplicates/0
//Description: Given a string, remove duplicates from it.
public class RemoveDuplicateCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            System.out.println(removeDuplicates(scanner.nextLine()));
        }
    }

    //Logic: uses hashing or hashmap to find if character is repeating.
    //instead of hashmap, any array of size 256 can also be used
    public static String removeDuplicates(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        char[] chars = str.toCharArray();
        int length = chars.length;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (!map.containsKey(chars[i])) {
                builder.append(chars[i]);
                map.put(chars[i], 1);
            }
        }

        return builder.toString();
    }
}
