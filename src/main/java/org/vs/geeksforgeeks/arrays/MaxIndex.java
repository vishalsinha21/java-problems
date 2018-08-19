package org.vs.geeksforgeeks.arrays;

import java.util.Scanner;

//Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
public class MaxIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(findMaxIndex(arr));
        }
    }

    private static int findMaxIndex(int[] arr) {
        int length = arr.length;
        int maxDiff = length - 1;

        int index = 0;

        while (maxDiff > 0) {
            index = 0;
            while (index + maxDiff < length) {
                if (arr[index] <= arr[index + maxDiff]) {
                    return maxDiff;
                }
                index++;
            }
            --maxDiff;
        }

        return 0;
    }
}
