package org.vs.others.sort;

import static org.vs.data.structures.sorting.CommonUtil.printArray;
import static org.vs.data.structures.sorting.CommonUtil.swap;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 8, 5, 14, 2, 67, 54, 32, 12};
        int length = arr.length;
        int maxIndex = length - 1;

        for (int i = 0; i < maxIndex; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            printArray(arr);
        }

    }
}
