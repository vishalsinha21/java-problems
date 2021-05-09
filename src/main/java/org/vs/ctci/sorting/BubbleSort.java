package org.vs.ctci.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 3, 1};

        bubbleSort(arr);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    print(arr);
                    System.out.println();
                }

            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
