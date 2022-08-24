package org.vs.hackerrank.tree.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapUsingPriorityQueue {

    public static void main(String[] args) {
        minHeapDemo();
        //maxHeapDemo();
    }

    private static void minHeapDemo() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(20);
        System.out.println(minHeap.peek());
        minHeap.add(30);
        System.out.println(minHeap.peek());
        minHeap.add(10);
        System.out.println(minHeap.peek());
        minHeap.add(40);
        System.out.println(minHeap.peek());
        minHeap.add(50);
        System.out.println(minHeap.peek());
        minHeap.add(3);
        System.out.println(minHeap.peek());
    }

    private static void maxHeapDemo() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.add(20);
        System.out.println(maxHeap.peek());
        maxHeap.add(30);
        System.out.println(maxHeap.peek());
        maxHeap.add(10);
        System.out.println(maxHeap.peek());
        maxHeap.add(40);
        System.out.println(maxHeap.peek());
        maxHeap.add(50);
        System.out.println(maxHeap.peek());
        maxHeap.add(3);
        System.out.println(maxHeap.peek());
    }
}
