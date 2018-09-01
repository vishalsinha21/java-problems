package org.vs.geeksforgeeks.hashing.SubArrayWithZeroSum;

import java.util.HashMap;

//The idea is that the sum will repeat if sub array sum is zero
public class Solution {

    public static void main(String arg[]) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));
    }

    static int maxLen(int arr[]) {
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }

            if (sum == 0) {
                maxLen = i + 1;
            }

            Integer value = map.get(sum);

            if (value != null) {
                //if sum is found then update index by subtracting previous index
                maxLen = Math.max(maxLen, i - value);
            } else {
                //store the index of sum
                map.put(sum, maxLen);
            }
        }

        return maxLen;
    }


}
