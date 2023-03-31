package org.vs.practice;

import java.util.Arrays;

import static org.vs.hackerrank.array.ArrayUtil.swap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 1, 4, 3, 7, 9, 2};
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        int length = arr.length;
        int nonLeafNodes = length / 2 - 1;

        for (int i = nonLeafNodes; i >= 0; i--) {
            heapify(arr, length, i);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (i != largest) {
            swap(arr, i, largest);
            heapify(arr, length, largest);
        }
    }

}
