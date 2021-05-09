package org.vs.geeksforgeeks.hashing.array_subset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//URL: https://practice.geeksforgeeks.org/problems/array-subset-of-another-array/0
//Description: Given 2 array, check whether arr2[] is a subset of arr1[] or not
public class ArraySubset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arr1Length = scanner.nextInt();
            int arr2Length = scanner.nextInt();

            int[] arr1 = new int[arr1Length];
            int[] arr2 = new int[arr2Length];

            for (int j = 0; j < arr1Length; j++) {
                arr1[j] = scanner.nextInt();
            }
            for (int j = 0; j < arr2Length; j++) {
                arr2[j] = scanner.nextInt();
            }

            System.out.println(isSubset(arr1, arr2));
        }
    }

    //Logic: put first array arr1 in map. Then iterate arr2 and for each element check if it is present in map.
    //if even a single element is not present then return No, else Yes
    public static String isSubset(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i])) {
                return "No";
            }
        }

        return "Yes";
    }
}
