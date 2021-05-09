package org.vs.others.array;

import static org.vs.data.structures.sorting.CommonUtil.printArray;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("before");
        printArray(arr);

        arr = rotate(arr, 3);
        System.out.println("after");
        printArray(arr);
    }

    private static int[] rotate(int[] arr, int rotateCount) {
        rotateCount = rotateCount % arr.length;
        for (int i = 0; i < rotateCount; i++) {
            arr = rotateOnce(arr);
        }

        return arr;
    }

    private static int[] rotateOnce(int[] arr) {
        int size = arr.length;
        int[] temp = new int[size];

        for (int i = 0; i < size - 1; i++) {
            temp[i] = arr[i + 1];
        }

        temp[size - 1] = arr[0];
        return temp;
    }
}
