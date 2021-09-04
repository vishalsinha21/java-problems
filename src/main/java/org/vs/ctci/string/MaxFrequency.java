package org.vs.ctci.string;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5, 1, 2, 2, 2, 3, 3, 3, 3};
        System.out.println(findNumberWithMaxFrequency(arr));
    }

    private static int findNumberWithMaxFrequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int numberWithMaxFreq = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int newFrequency = map.get(arr[i]) + 1;
                map.put(arr[i], newFrequency);
                if (newFrequency > max) {
                    max = newFrequency;
                    numberWithMaxFreq = arr[i];
                }
            } else {
                map.put(arr[i], 1);
            }
        }

        return numberWithMaxFreq;
    }
}
