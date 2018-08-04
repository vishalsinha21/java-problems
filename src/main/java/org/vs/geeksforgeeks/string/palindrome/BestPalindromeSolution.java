package org.vs.geeksforgeeks.string.palindrome;

import java.util.Scanner;

public class BestPalindromeSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println(findLongestPalindrome(scanner.next()));
        }
    }

    private static String findLongestPalindrome(String str) {
        int length = str.length();
        int maxLength = 1;
        int startIndex = 0;
        int left = 0;
        int right = 0;
        int subStrLength = 0;

        for (int i = 1; i < length; i++) {

            //loop twice, one for odd and one for even
            for (int j = 0; j < 2; j++) {
                left = i - 1;
                right = (j % 2 == 0) ? i + 1 : i;

                while (left >= 0 && right < length) {
                    if (str.charAt(left) != str.charAt(right)) {
                        break;
                    } else {
                        subStrLength = right - left + 1;
                        if (subStrLength > maxLength) {
                            startIndex = left;
                            maxLength = subStrLength;
                        }
                        left--;
                        right++;
                    }
                }
            }
        }
        return str.substring(startIndex, startIndex + maxLength);
    }

}
