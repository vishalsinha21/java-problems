package org.vs.geeksforgeeks.arrays.missingnumber;

import java.util.Scanner;

public class GFG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];
            int sum = 0;

            for (int j = 0; j < arrSize - 1; j++) {
                arr[j] = scanner.nextInt();
                sum += arr[i];
            }

            int totalSum = (arrSize * (arrSize + 1)) / 2;
            System.out.println(totalSum - sum);
        }
    }

}
