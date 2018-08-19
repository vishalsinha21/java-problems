package org.vs.geeksforgeeks.heap;

import java.util.Arrays;

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
        fixHeap(index);
        size++;
    }

    public void decreaseKey(int key, int value) {
        arr[key] = value;
        fixHeap(key);
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }

        int min = arr[0];
        swap(arr, 0, size - 1);
        arr[size - 1] = 0;
        size--;
        heapify(0);

        return min;
    }

    public void delete(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    private void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int smallest = 0;

        if (left < size - 1 && (arr[index] > arr[left] || arr[index] > arr[right])) {
            if (arr[left] < arr[right]) {
                smallest = left;
            } else {
                smallest = right;
            }
            swap(arr, index, smallest);
            heapify(smallest);
        }
    }

    private void fixHeap(int childIndex) {
        while (arr[childIndex] < arr[parent(childIndex)]) {
            swap(arr, childIndex, parent(childIndex));
            childIndex = parent(childIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int left(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int right(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int min() {
        return arr[0];
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(40);
        minHeap.add(15);
        minHeap.add(50);
        minHeap.add(25);

        System.out.println(minHeap.min());
        System.out.println(minHeap);

        minHeap.decreaseKey(3, 5);
        System.out.println(minHeap);

        System.out.println(minHeap.extractMin());
        System.out.println(minHeap);

        minHeap.delete(1);
        System.out.println(minHeap);
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
