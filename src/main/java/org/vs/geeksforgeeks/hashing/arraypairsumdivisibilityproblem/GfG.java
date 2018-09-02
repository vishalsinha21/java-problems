package org.vs.geeksforgeeks.hashing.arraypairsumdivisibilityproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

            int divider = scanner.nextInt();
            System.out.println(checkDivisibility(arr, divider) ? "True" : "False");
        }
    }

    private static boolean checkDivisibility(int[] arr, int divider) {
        HashMap<Integer, Integer> map = new HashMap<>();

        if (arr.length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % divider;
            if (map.containsKey(remainder)) {
                map.put(remainder, map.get(remainder) + 1);
            } else {
                map.put(remainder, 1);
            }
        }

        int productSum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            productSum += entry.getKey() * entry.getValue();
        }

        return productSum % divider == 0 ? true : false;
    }

}
