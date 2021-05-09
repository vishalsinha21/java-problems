package org.vs.others.sorting;

public class CommonUtil {

    public static void swap(int[] arr, int a, int b) {
        int temp = 0;

        temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}
