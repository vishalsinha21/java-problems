package org.vs.udemy.sorting;

/*
Bubble sort always starts at beginning
Compare to neighbor and swap if the order is wrong
In one loop largest number bubbles up to the end of array
Continue this until all list is sorted
*/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, -1, 6, -3};
        //Initialize as the last index of array
        int unsortedPartitionIndex = arr.length - 1;

        //Always continue from beginning
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < unsortedPartitionIndex; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

            printArray(arr);
            //Decrement the unsortedPartitionIndex
            unsortedPartitionIndex--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
