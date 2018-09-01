package org.vs.geeksforgeeks.hashing.SubArrayWithZeroSum;

import java.util.Scanner;

//length of the largest subarray which has sum 0
public class GfG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];

            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }

            System.out.println(maxLen(arr, arr.length));
        }
    }

    private static int maxLen(int arr[], int n) {
        int length = n;
        int maxLen = length;
        int sum = 0;

        while (maxLen > 0) {
            sum = 0;
            for (int i = 0; i < length; i++) {
                sum += arr[i];

                if (i >= maxLen - 1) {
                    if (sum == 0) {
                        return maxLen;
                    }
                    sum = sum - arr[i - maxLen + 1];
                }
            }
            --maxLen;
        }

        return maxLen;
    }
}
