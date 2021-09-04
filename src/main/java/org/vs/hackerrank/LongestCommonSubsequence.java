package org.vs.hackerrank;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(commonChild("ABBD", "ADDBGGHIBHHD"));
    }

    //recursive way
    public static int lcs(String str1, String str2) {
        if (str1.isBlank() || str2.isBlank()) {
            return 0;
        }

        System.out.println("str1:" + str1 + "|str2:" + str2);
        char str1lastChar = str1.charAt(str1.length() - 1);
        char str2lastChar = str2.charAt(str2.length() - 1);

        if (str1lastChar == str2lastChar) {
            return 1 + lcs(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
        } else {
            return Math.max(lcs(str1, str2.substring(0, str2.length() - 1)),
                    lcs(str1.substring(0, str1.length() - 1), str2));
        }
    }

    //dynamic programming
    public static int commonChild(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] arr = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }

        return arr[length1][length2];
    }
}
