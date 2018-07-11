package org.vs.hackerrank.queue.queueusingstacks;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;

    public Solution() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                int num = scanner.nextInt();
                solution.enqueue(num);
            } else if (choice == 2) {
                solution.dequeue();
            } else if (choice == 3) {
                solution.peek();
            }
        }
    }

    private void enqueue(int num) {
        enqueueStack.push(num);
    }

    private void peek() {
        checkDequeueStack();
        System.out.println(dequeueStack.peek());
    }

    private void checkDequeueStack() {
        if (dequeueStack.empty()) {
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    private Integer dequeue() {
        checkDequeueStack();
        return dequeueStack.pop();
    }

}
