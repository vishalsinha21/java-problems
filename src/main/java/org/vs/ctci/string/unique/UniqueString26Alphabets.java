package org.vs.ctci.string.unique;

public class UniqueString26Alphabets {

    public static void main(String[] args) {
        System.out.println(isUniqueString("vishal")); //true
        System.out.println(isUniqueString("h")); //true
        System.out.println(isUniqueString("hello")); //false
        System.out.println(isUniqueString("Ll")); //false
    }

    public static boolean isUniqueString(String str) {
        char[] chars = str.toCharArray();
        int[] charCount = new int[26];

        for (char c : chars) {
            int index = getIndexOfChar(c);
            charCount[index]++;
            if (charCount[index] > 1) return false;
        }
        return true;
    }

    private static int getIndexOfChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }

        return -1;
    }

    private static int getIndex(char c) {
        if (c == 'a' || c == 'A') return 0;
        if (c == 'b' || c == 'B') return 1;
        if (c == 'c' || c == 'C') return 2;
        if (c == 'd' || c == 'D') return 3;
        if (c == 'e' || c == 'E') return 4;
        if (c == 'f' || c == 'F') return 5;
        if (c == 'g' || c == 'G') return 6;
        if (c == 'h' || c == 'H') return 7;
        if (c == 'i' || c == 'I') return 8;
        if (c == 'j' || c == 'J') return 9;
        if (c == 'k' || c == 'K') return 10;
        if (c == 'l' || c == 'L') return 11;
        if (c == 'm' || c == 'M') return 12;
        if (c == 'n' || c == 'N') return 13;
        if (c == 'o' || c == 'O') return 14;
        if (c == 'p' || c == 'P') return 15;
        if (c == 'q' || c == 'Q') return 16;
        if (c == 'r' || c == 'R') return 17;
        if (c == 's' || c == 'S') return 18;
        if (c == 't' || c == 'T') return 19;
        if (c == 'u' || c == 'U') return 20;
        if (c == 'v' || c == 'V') return 21;
        if (c == 'w' || c == 'W') return 22;
        if (c == 'x' || c == 'X') return 23;
        if (c == 'y' || c == 'Y') return 24;
        if (c == 'z' || c == 'Z') return 25;

        return -1;
    }
}
