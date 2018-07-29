package org.vs.geeksforgeeks.arrays.kadane;

import java.util.Scanner;

//Given an array containing both negative and positive integers.
//Find the contiguous sub-array with maximum sum.
public class GFG {

    public static int maxSumOfSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];
            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(maxSumOfSubArray(arr));
        }
    }

    public static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += a[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

}
