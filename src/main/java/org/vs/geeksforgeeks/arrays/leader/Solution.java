package org.vs.geeksforgeeks.arrays.leader;

import java.util.ArrayList;
import java.util.List;
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

            findLeader(arr);
            System.out.println();
        }
    }


    public static void findLeader(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxSoFar) {
                list.add(arr[i]);
                maxSoFar = arr[i];
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
