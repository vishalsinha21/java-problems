package org.vs.hackerrank.tree.heap;

import java.util.Arrays;

public class MinHeap {

    int capacity = 0;
    int size;
    int[] arr = null;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void insert(int data) {
        if (size == capacity) {
            throw new IllegalStateException("heap is full");
        }

        System.out.println("inserting " + data);
        int index = size;
        arr[index] = data;

        while (arr[index] < arr[parent(index)]) {
            swap(arr, index, parent(index));
            index = parent(index);
        }

        size++;
    }

    public void delete(int index) {
        if (index >= size) {
            throw new IllegalStateException("invalid index");
        }

        System.out.println("deleting " + arr[index]);
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    public void decreaseKey(int index, int newVal) {
        if (index >= size) {
            throw new IllegalStateException("invalid index");
        }

        System.out.println(String.format("changing value of a[%d] from %d to %d", index, arr[index], newVal));
        arr[index] = newVal;

        while (arr[index] < arr[parent(index)]) {
            swap(arr, index, parent(index));
            index = parent(index);
        }

    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("heap is empty");
        }

        System.out.println("extracting and deleting minimum");
        int min = arr[0];
        swap(arr, 0, size - 1);
        size--;
        heapify(0);

        return min;
    }

    public void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int smallest = index;

        if (left <= size - 1 && arr[index] > arr[left]) {
            smallest = left;
        }

        if (right <= size - 1 && arr[smallest] > arr[right]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(arr, index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        //System.out.println(String.format("swapping arr[%d] (%d) with arr[%d] (%d)", i, arr[i], j, arr[j]));
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getMin() {
        return arr[0];
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(15);

        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        System.out.println(heap);
        System.out.println("size::" + heap.size);

        heap.decreaseKey(3, 8);
        System.out.println(heap);

        System.out.println("min:" + heap.extractMin());
        System.out.println(heap);
        System.out.println("size::" + heap.size);

        heap.delete(1);
        System.out.println(heap);
        System.out.println("size::" + heap.size);
    }

}
