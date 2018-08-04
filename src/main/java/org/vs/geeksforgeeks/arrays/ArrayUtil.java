package org.vs.geeksforgeeks.arrays;

import java.util.Arrays;

public class ArrayUtil {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int[] reverseArr = reverse(arr);
        System.out.println(Arrays.toString(reverseArr));
    }

    public static int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int temp = 0;

        while (end > start) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }

}
