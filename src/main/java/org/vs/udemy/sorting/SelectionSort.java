package org.vs.udemy.sorting;

/*
Selection sort keeps track of index of the smallest number
It compares each number to the number at smallest index, and change the smallest index if smaller number is found
With each iteration smallest number comes to top of unsorted list
*/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, -1, 6, 3};

        int smallestNumIndex;

        for (int i = 0; i < arr.length; i++) {
            smallestNumIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallestNumIndex] > arr[j]) {
                    smallestNumIndex = j;
                }
            }
            swap(arr, i, smallestNumIndex);
            printArray(arr);
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
