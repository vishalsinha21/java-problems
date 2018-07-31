package org.vs.geeksforgeeks.arrays.equilibrium;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];
            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(findEquilibriumPoint(arr));
        }
    }

    public static int findEquilibriumPoint(int[] arr) {
        int length = arr.length;

        if (length == 1) {
            return 1;
        }

        int totalSum = 0;
        int headSum = 0;
        int tailSum = 0;

        for (int i = 0; i < length; i++) {
            totalSum += arr[i];
        }

        for (int i = 0; i < length; i++) {
            tailSum = totalSum - headSum - arr[i];
            if (headSum == tailSum) {
                return i + 1;
            }
            headSum += arr[i];
        }

        return -1;
    }
}
