package org.vs.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int[] arr = {10, 20, 30, 40, 15, 50, 25};

        Arrays.stream(arr).forEach(i -> {
                minHeap.offer(i);
                maxHeap.offer(i);
        });

        System.out.println(minHeap);
        System.out.println(maxHeap);

        System.out.println("size:" + minHeap.size());
        System.out.println("size:" + maxHeap.size());

        System.out.println("minHeap peek: " + minHeap.peek());
        System.out.println("maxHeap peek: " + maxHeap.peek());

        System.out.println("size:" + minHeap.size());
        System.out.println("size:" + maxHeap.size());

        System.out.println("minHeap peek: " + minHeap.poll());
        System.out.println("maxHeap peek: " + maxHeap.poll());

        System.out.println("size:" + minHeap.size());
        System.out.println("size:" + maxHeap.size());

        System.out.println(minHeap);
        System.out.println(maxHeap);
    }
}
