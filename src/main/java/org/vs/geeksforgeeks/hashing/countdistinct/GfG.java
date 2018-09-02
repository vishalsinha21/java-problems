package org.vs.geeksforgeeks.hashing.countdistinct;

import java.util.HashMap;
import java.util.Scanner;

public class GfG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arrSize = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[arrSize];

            for (int j = 0; j < arrSize; j++) {
                arr[j] = scanner.nextInt();
            }

            countDistinct(arr, k, arr.length);
            System.out.println();
        }
    }

    static void countDistinct(int arr[], int k, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            //if map contains key then increment existing count else add to map with count 1
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }

            //decrement/remove entry from map once i >= k
            if (i >= k) {
                Integer val = map.get(arr[i - k]);
                if (val == 1) {
                    map.remove(arr[i - k]);
                } else {
                    map.put(arr[i - k], val - 1);
                }
            }

            if (i >= k - 1) {
                System.out.print(map.size() + " ");
            }
        }
    }
}
