package org.vs.others.recursion;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int mid = (int) Math.floor((startIndex + endIndex) / 2);
            mergeSort(arr, startIndex, mid);
            mergeSort(arr, mid + 1, endIndex);
            merge(arr, startIndex, mid, endIndex);
        }

    }

    private static void merge(int[] arr, int startIndex, int mid, int endIndex) {
        System.out.println(String.format("startIndex midIndex endIndex:: %s %s %s", startIndex, mid, endIndex));

        int[] left = new int[mid - startIndex + 1];
        int[] right = new int[endIndex - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[startIndex + i];
        }
        System.out.println("left:" + Arrays.toString(left));

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + 1 + i];
        }
        System.out.println("right:" + Arrays.toString(right));

        int leftIndex = 0;
        int rightIndex = 0;
        int index = startIndex;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[index] = left[leftIndex];
                leftIndex++;
            } else {
                arr[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while (index < arr.length && leftIndex < left.length) {
            arr[index] = left[leftIndex];
            index++;
            leftIndex++;
        }

        while (index < arr.length && rightIndex < right.length) {
            arr[index] = right[rightIndex];
            index++;
            rightIndex++;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13, 6, 19, 18, 20, 5, 9, 10, 87, 12, 45, 65, 12, 3 , 7};
        mergeSort(arr);

        String[] strArr = new String[]{"one", "two"};

        System.out.println(strArr);

    }

}
