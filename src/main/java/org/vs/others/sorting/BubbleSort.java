package org.vs.others.sorting;

import static org.vs.data.structures.sorting.CommonUtil.printArray;
import static org.vs.data.structures.sorting.CommonUtil.swap;

/**
 * compare first two adjacent elements in array and swap if first is greater than second
 * then do this with next 2 adjacent numbers
 * this way the largest number bubbles up to the last place in array
 * <p>
 * now repeat this process again from starting index to the last element - n
 * where n is the number of times you have performed steps given above
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {21, 8, 5, 9, 12, 4, 3, 13, 17, 14, 4, 5};
        int size = arr.length;
        int maxIndex = size - 1;

        for (int i = 0; i < maxIndex - 1; i++) {
            for (int j = 0; j < maxIndex - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            printArray(arr);
        }

        System.out.println("final:::");
        printArray(arr);
    }
}
