package org.vs.geeksforgeeks.arrays.triplets;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//URL: https://practice.geeksforgeeks.org/problems/count-the-triplets/0
//Description: Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
public class Triplets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];

            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }

            System.out.println(findTriplets(arr));
        }
    }

    private static int findTriplets(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int length = arr.length;
        //put all the elements in map, so its easier to find of map contains sum
        for (int i = 0; i < length; i++) {
            map.put(arr[i], 1);
        }

        int tripletCount = 0;
        //sum all possible pairs and check if their sum is present in map, increment count if present
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = arr[i] + arr[j];

                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                    tripletCount++;
                }
            }
        }


        return tripletCount == 0 ? -1 : tripletCount;
    }
}
