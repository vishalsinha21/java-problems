package org.vs.hackerrank.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayUtil {


    public static void main(String[] args) {
    }


    //https://www.hackerrank.com/challenges/contacts/problem
    static int[] contacts(String[][] queries) {
        Map<String, List<String>> contacts = new HashMap<>();

        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String contact = queries[i][1];
            String firstAlphabet = contact.substring(0, 1);
            List<String> list = contacts.get(firstAlphabet);

            switch (queries[i][0]) {
                case "add":
                    if (list == null) {
                        List<String> newList =new ArrayList<>();
                        newList.add(contact);
                        contacts.put(firstAlphabet, newList);
                    } else {
                        list.add(contact);
                        contacts.put(firstAlphabet, list);
                    }
                    break;
                case "find":
                    int count = 0;
                    if (list != null) {
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).startsWith(queries[i][1])) {
                                count++;
                            }
                        }
                    }
                    counts.add(count);
                    break;
            }
        }

        return counts.stream().mapToInt(i -> i).toArray();
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        long max = 0;

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0] - 1; j <= queries[i][1] - 1; j++) {
                arr[j] += queries[i][2];
                max = Math.max(max, arr[j]);
            }
        }

        return max;
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
