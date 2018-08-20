package org.vs.geeksforgeeks.heap.median;

import java.util.Arrays;
import java.util.Scanner;


//median in a stream using heap sort, correct but need performance improvement
public class MinHeap {

    int capacity = 10;
    int[] arr = null;
    int size = 0;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void add(int data) {
        int index = size;
        arr[index] = data;
        heapifyUp(index);
        size++;
    }

    public void decreaseKey(int key, int value) {
        arr[key] = value;
        heapifyUp(key);
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }

        int min = arr[0];
        swap(arr, 0, size - 1);
        arr[size - 1] = 0;
        size--;
        heapifyDown(arr, 0, size);

        return min;
    }

    public void delete(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    private static void heapifyDown(int[] arr, int index, int size) {
        int left = left(index);
        int right = right(index);
        int smallest = left;

        if (left < size - 1 && arr[index] > arr[left]) {
            if (right < size - 1 && arr[index] > arr[right] && arr[right] < arr[left]) {
                smallest = right;
            }
            swap(arr, index, smallest);
            heapifyDown(arr, smallest, size);
        }
    }

    private void heapifyUp(int childIndex) {
        while (arr[childIndex] < arr[parent(childIndex)]) {
            swap(arr, childIndex, parent(childIndex));
            childIndex = parent(childIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private static int left(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private static int right(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int min() {
        return arr[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        MinHeap heap = new MinHeap(size);

        for (int i = 0; i < size; i++) {
            heap.add(scanner.nextInt());
            int[] arr = heapSort(heap.arr, heap.size);
            System.out.println(getMedian(arr, heap.size));
        }
    }

    private static int getMedian(int[] arr, int size) {
        if (size % 2 == 1) {
            return arr[size / 2];
        }

        return (arr[size / 2] + arr[(size - 1) / 2]) / 2;
    }


    public static int[] heapSort(int[] original, int heapSize) {
        int[] arr = Arrays.stream(original).toArray();
        int size = heapSize;

        for (int i = 1; i < size; i++) {
            swap(arr, 0, size - i);
            heapifyDown(arr, 0, size + 1 - i);
        }

        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
