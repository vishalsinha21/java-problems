package org.vs.geeksforgeeks.heap.median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median {

    public static void main(String[] args) {

        //higher half of all numbers
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        //lower half of all numbers
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());

        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();

        for (int i = 0; i < arrSize; i++) {
            addToHeap(higher, lower, scanner.nextInt());
            System.out.println(getMedian(lower, higher));
        }

    }

    private static void addToHeap(PriorityQueue<Integer> higher, PriorityQueue<Integer> lower, int num) {
        if (lower.size() <= higher.size()) {
            if (lower.isEmpty()) {
                lower.offer(num);
            } else if (num < higher.peek()) {
                lower.offer(num);
            } else {
                lower.offer(higher.poll());
                higher.offer(num);
            }
        } else {
            if (num > lower.peek()) {
                higher.offer(num);
            } else {
                higher.offer(lower.poll());
                lower.offer(num);
            }
        }
    }

    private static int getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        //return 0 if heaps are empty
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        }

        //if number of elements are odd then max heap size will be greater than min heap size
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
