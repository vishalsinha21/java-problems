package org.vs.others.sort;

import static org.vs.data.structures.sorting.CommonUtil.printArray;
import static org.vs.data.structures.sorting.CommonUtil.swap;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{32, 5, 7, 12, 56, 34, 44, 87, 1, 4};
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int k = i + 1; k > 0; k--) {
                if (arr[k] < arr[k - 1]) {
                    swap(arr, k, k - 1);
                }
            }
            printArray(arr);
        }
    }
}
