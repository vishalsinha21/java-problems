package org.vs.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {

    public static List<Integer> countingSort1(List<Integer> arr) {
        Integer[] result = new Integer[100];
        Arrays.fill(result, 0);
        for (Integer i : arr) {
            result[i]++;
        }

        return Arrays.asList(result);
    }

    public static List<Integer> countingSort2(List<Integer> arr) {
        List<Integer> result = new ArrayList(100);

        for (Integer i : arr) {
            result.set(i, result.get(i) != null ? result.get(i) + 1 : 0);
        }

        return result;
    }
}
