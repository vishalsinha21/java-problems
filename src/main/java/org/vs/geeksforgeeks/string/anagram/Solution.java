package org.vs.geeksforgeeks.string.anagram;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String str1 = scanner.next();
            String str2 = scanner.next();

            System.out.println(areAnagrams(str1, str2) ? "YES" : "NO");
        }
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
