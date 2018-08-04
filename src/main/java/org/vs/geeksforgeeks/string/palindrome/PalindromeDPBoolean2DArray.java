package org.vs.geeksforgeeks.string.palindrome;

import java.util.Scanner;


/*
uses boolean 2D array to store whether substring from i to j is palindrome and then uses this info to find bigger palindromes
*/
public class PalindromeDPBoolean2DArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println(findLongestPalindrome(scanner.next()));
        }
    }

    private static String findLongestPalindrome(String str) {
        int length = str.length();
        boolean[][] table = new boolean[length][length];
        int max = 1;
        int subStringStartIndex = 0;
        int count = 0;

        for (int i = 0; i < length; i++) {
            table[i][i] = true;
        }

        for (int i = 0; i < length - 1; i++) {
            boolean b = str.charAt(i) == str.charAt(i + 1);
            if (b) {
                max = 2;
                count++;

                if (count == 1) {
                    subStringStartIndex = i;
                }
                table[i][i + 1] = b;
            }
        }

        for (int k = 3; k <= length; k++) {
            for (int i = 0; i + k <= length; i++) {
                if (str.charAt(i) == str.charAt(i + k - 1) && table[i + 1][i + k - 2]) {
                    if (k > max) {
                        count = 0;
                    }
                    max = k;
                    count++;
                    if (count == 1) {
                        subStringStartIndex = i;
                    }
                    table[i][i + k - 1] = true;
                }
            }
        }

        return str.substring(subStringStartIndex, subStringStartIndex + max);

    }

}
