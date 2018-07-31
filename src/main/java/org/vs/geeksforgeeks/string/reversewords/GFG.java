package org.vs.geeksforgeeks.string.reversewords;

import java.util.Scanner;

public class GFG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String str = scanner.next();
            reverseWords(str);
        }
    }

    private static void reverseWords(String str) {
        String[] split = str.split("\\.");

        for (int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i] + ((i == 0) ? "" : "."));
        }
        System.out.println();
    }
}
