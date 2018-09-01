package org.vs.geeksforgeeks.arrays.subarray_max;

import java.util.Scanner;

public class SubArrayMax {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int subArrSize = scanner.nextInt();

            int[] arr = new int[arrSize];
            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }

            findSubArrMax(arr, subArrSize);
        }

    }

    private static void findSubArrMax(int[] arr, int subArrSize) {
        for (int i = 0; i + subArrSize - 1 < arr.length; i++) {
            System.out.print(findMax(arr, i, i + subArrSize - 1) + " ");
        }
        System.out.println();
    }

    private static int findMax(int[] arr, int startIndex, int endIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
