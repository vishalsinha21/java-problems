package org.vs.practice;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {33, 31, 40, 8, 12, 17, 25, 42};
        shellSort(arr, 8);
    }

    static void shellSort(int arr[], int n) {
        /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */
        for (int interval = n / 2; interval > 0; interval /= 2) {
            System.out.println("interval: " + interval);
            for (int i = interval; i < n; i += 1) {
                System.out.println("i: " + i);
                /* store arr[i] to the variable temp and make the ith position empty */
                int temp = arr[i];
                int j = i;
                while (j - interval >= 0 && arr[j - interval] > temp) {
                    arr[j] = arr[j - interval];
                    j -= interval;
                }

                /* put temp (the original arr[i]) in its correct position */
                arr[j] = temp;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(Arrays.toString(arr));
        }
    }


}
