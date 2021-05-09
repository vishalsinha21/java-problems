package org.vs.others.sort;

import org.vs.others.sorting.CommonUtil;//In this sorting algorithm, we start with first element in array and compare with next element and keep track of index of minimum number.
//After first loop, we have index of minimum number in array and then we swap it first element in array.
//We again start form next element in array and repeat it until all array is sorted.
//Its called selection sort, cos in a way we select the minimum number in array and then bring it to its right position.

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{21, 3, 6, 8, 13, 45, 76, 32, 23, 44, 66};
        int length = arr.length;
        int maxIndex = length - 1;

        for (int i = 0; i < maxIndex; i++) {
            int minIndex = i;

            for (int j = i + 1; j <= maxIndex; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            CommonUtil.swap(arr, i, minIndex);
            CommonUtil.printArray(arr);
        }

    }
}
