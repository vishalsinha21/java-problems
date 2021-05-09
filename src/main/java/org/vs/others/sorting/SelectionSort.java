package org.vs.others.sorting;


import static org.vs.data.structures.sorting.CommonUtil.printArray;
import static org.vs.data.structures.sorting.CommonUtil.swap;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {21, 8, 5, 9, 12, 4, 3, 13, 17, 14, 4, 5};
        int size = arr.length;
        int minNumIndex = 0;


        for (int i = 0; i < size - 1; i++) {
            minNumIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minNumIndex]) {
                    minNumIndex = j;
                }
            }

            System.out.println("smallest number::" + arr[minNumIndex]);
            swap(arr, i, minNumIndex);
            printArray(arr);
        }

        System.out.println("final::");
        printArray(arr);
    }


}
