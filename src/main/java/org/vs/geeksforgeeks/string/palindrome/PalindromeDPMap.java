package org.vs.geeksforgeeks.string.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//this DP strategy isnt very useful cos we are looking for larger strings first
//so a map is not really useful but taking huge space
public class PalindromeDPMap {

    private static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            map.clear();
            System.out.println(getLongestPalindromeLength(scanner.next()));
        }
    }

    private static String getLongestPalindromeLength(String str) {
        int length = str.length();
        int subStringLength = length;

        for (int i = subStringLength; i >= 2; i--) {
            for (int j = 0; j + i <= length; j++) {
                String substring = str.substring(j, j + i);
                boolean palindrome = isPalindromeWithDP(substring);
                if (palindrome) {
                    return substring;
                }
            }
        }

        return str.substring(0, 1);
    }

    private static boolean isPalindromeWithDP(String substring) {
        boolean palindrome;
        if (map.containsKey(substring)) {
            palindrome = map.get(substring);
        } else {
            palindrome = isPalindrome(substring);
            map.put(substring, palindrome);
        }
        return palindrome;
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        boolean isOdd = length % 2 == 1 ? true : false;
        int middle = length / 2;

        int left = isOdd ? middle : middle - 1;
        int right = middle;

        for (int i = 0; i < length - middle; i++) {
            if (str.charAt(left - i) != str.charAt(right + i)) {
                return false;
            }
        }

        return true;
    }

}
