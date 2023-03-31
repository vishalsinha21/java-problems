package org.vs.practice;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};

        // Function Call
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixSort(int arr[]) {
        // Find the maximum number to know number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int exp) {
        int size = arr.length;
        int output[] = new int[size];
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (int i = 0; i < size; i++) {
            int significantDigit = (arr[i] / exp) % 10;
            count[significantDigit]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = size - 1; i >= 0; i--) {
            int significantDigit = (arr[i] / exp) % 10;
            output[count[significantDigit] - 1] = arr[i];
            count[significantDigit]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (int i = 0; i < size; i++)
            arr[i] = output[i];
    }


    // A utility function to print an array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }


}