package org.vs.geeksforgeeks.string.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindrome {

    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            findLongestPalindrome(scanner.next());
        }
    }

    private static void findLongestPalindrome(String str) {
        int length = str.length();
        int largestPalindromeSize = length;
        int index = 0;
        int endIndex = 0;
        boolean found = false;

        while (largestPalindromeSize >= 1) {
            endIndex = index + largestPalindromeSize;
            while (endIndex < length + 1) {
                String subStr = str.substring(index, endIndex);
                if (isPalindrome(subStr)) {
                    found = true;
                    System.out.println(subStr);
                    break;
                }
                index++;
                endIndex = index + largestPalindromeSize;
            }

            if (found) {
                break;
            }
            index = 0;
            largestPalindromeSize--;
        }
    }

    private static boolean isPalindrome(String str) {
        if (map.containsKey(str)) {
            return map.get(str);
        } else {
            boolean result = str.equals(reverse(str));
            map.put(str, result);
            return result;
        }
    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        char temp;
        for (int i = 0; i < (length / 2); i++) {
            temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }
        return new String(chars);
    }

}
