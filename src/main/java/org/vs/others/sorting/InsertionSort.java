package org.vs.others.sorting;

//In this algo, you consider one element and compare to all previous elements in array and insert in at the right position.
//Pretty similar to how we would arrange playing cards in hand.

import static org.vs.data.structures.sorting.CommonUtil.printArray;
import static org.vs.data.structures.sorting.CommonUtil.swap;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {21, 8, 5, 9, 12, 4, 3, 13, 17, 14, 4, 5};
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            printArray(arr);
        }
    }


}
