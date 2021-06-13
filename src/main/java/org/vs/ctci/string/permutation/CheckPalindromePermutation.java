package org.vs.ctci.string.permutation;

public class CheckPalindromePermutation {

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("chch")); //true
        System.out.println(isPalindromePermutation("chcha")); //true
        System.out.println(isPalindromePermutation("chcha ")); //true
        System.out.println(isPalindromePermutation("chcha    ")); //true
        System.out.println(isPalindromePermutation("chcha    b")); //false
        System.out.println(isPalindromePermutation("Tact Coa")); //true
    }

    private static boolean isPalindromePermutation(String str) {
        char[] chars = str.toCharArray();
        int[] arr = new int[26];

        for (char ch : chars) {
            if (ch != ' ') {
                int index = getCharIndex(ch);
                arr[index]++;
            }
        }

        int countOfOddCharacters = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                countOfOddCharacters++;
            }
        }


        return countOfOddCharacters > 1 ? false : true;
    }

    private static int getCharIndex(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        }
        return -1;
    }

}
