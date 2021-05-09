package org.vs.geeksforgeeks.hashing.character_frequency;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//URL: https://www.geeksforgeeks.org/print-characters-frequencies-order-occurrence/
//Description: Given a string str containing only lowercase characters. The problem is to print the characters along with their frequency in order of their occurrence and in the given format explained in the examples below.
public class CharacterFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap();

        for (char ch : chars) {
            map.merge(ch, 1, (i, j) -> i + 1);
        }

        System.out.println(map);
    }
}
