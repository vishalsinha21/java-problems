package org.vs.hackerrank;

public class PalindromeIndex {

    public static int palindromeIndex(String s) {
        if (isPalindrome(s)) return -1;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String temp = new StringBuilder(s).deleteCharAt(i).toString();
            System.out.println(temp);
            if (isPalindrome(temp)) {
                return i;
            }
        }

        return 0;
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
