package org.vs.geeksforgeeks.arrays.subarraysum;

import java.util.Scanner;

public class GFG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int total = scanner.nextInt();
            int[] arr = new int[arrSize];

            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }

            findSubArrayWithSum(arr, total);
        }
    }

    public static void findSubArrayWithSum(int[] arr, int total) {
        int length = arr.length;
        int sum = 0;
        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < length) {
            if (sum < total && endIndex < length) {
                sum += arr[endIndex];
                endIndex++;
            }

            if (sum < total && endIndex == length) {
                break;
            }

            if (sum > total) {
                sum = sum - arr[startIndex];
                startIndex++;
            }

            if (sum == total) {
                System.out.println((startIndex + 1) + " " + endIndex);
                return;
            }
        }

        System.out.println(-1);
    }
}
