package org.vs.hackerrank;

public class SpecialSubstringCount {

    public static void main(String[] args) {
        System.out.println(substrCount(4, "aaaa"));
    }

    static long substrCount(int n, String s) {
        long count = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j < n; j++) {
                if (isSpecialString(chars, i, i + j)) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isSpecialString(char[] chars, int a, int b) {
        int length = b - a + 1;
        if (length % 2 == 0) {
            for (int i = a; i <= b; i++) {
                if (chars[i] != chars[a]) {
                    return false;
                }
            }
        }

        if (length % 2 == 1) {
            int mid = (a + b)/2;
            for (int i = a; i <= b; i++) {
                if (i != mid && chars[i] != chars[a]) {
                    return false;
                }
            }
        }

        return true;
    }
}
