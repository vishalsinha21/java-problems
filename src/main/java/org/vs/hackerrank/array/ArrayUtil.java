package org.vs.hackerrank.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayUtil {


    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1}
        };

        arrayManipulation(10, arr);

    }


    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0] - 1; j <= queries[i][1] - 1; j++) {
                arr[j] += queries[i][2];
            }
        }

        return Arrays.stream(arr).max().getAsLong();
    }

    //max index product
    static int solve(int[] arr) {

        int length = arr.length;
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i < length; i++) {
            left = 0;
            right = 0;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] > arr[i]) {
                    right = j + 1;
                    break;
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    left = j + 1;
                    break;
                }
            }

            int product = left * right;
            if (max < product) {
                max = product;
             }
        }

        return max;
    }

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Long> stringMap = Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(queries)
                .mapToInt(query -> stringMap.get(query) != null ? stringMap.get(query).intValue() : 0)
                .toArray();
    }

    public static void rotateArray(int[] arr, int times) {
        int length = arr.length;
        times = times % length;

        for (int i = 0; i < length; i++) {
            System.out.print(arr[(i + times) % length] + " ");
        }
    }


}
