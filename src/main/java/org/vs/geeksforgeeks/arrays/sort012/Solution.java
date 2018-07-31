package org.vs.geeksforgeeks.arrays.sort012;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int zeroCount = 0;
            int oneCount = 0;
            int twoCount = 0;

            for (int j = 0; j < arrSize; j++) {
                int number = scanner.nextInt();
                if (number == 0) {
                    zeroCount++;
                }
                if (number == 1) {
                    oneCount++;
                }
                if (number == 2) {
                    twoCount++;
                }
            }

            printSorted(zeroCount, oneCount, twoCount);
            System.out.println();
        }
    }

    private static void printSorted(int zeroCount, int oneCount, int twoCount) {
        for (int i = 0; i < zeroCount; i++) {
            System.out.print(0 + " ");
        }
        for (int i = 0; i < oneCount; i++) {
            System.out.print(1 + " ");
        }
        for (int i = 0; i < twoCount; i++) {
            System.out.print(2 + " ");
        }
    }
}
