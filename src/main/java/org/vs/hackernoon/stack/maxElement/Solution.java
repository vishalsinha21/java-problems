package org.vs.hackernoon.stack.maxElement;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Stack<StackNode> stack = new Stack();

        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            int choice = scanner.nextInt();

            if (choice == 1) {
                int data = scanner.nextInt();
                if (stack.empty()) {
                    stack.push(new StackNode(data, data));
                } else {
                    stack.push(new StackNode(data, Math.max(data, stack.peek().currMax)));
                }
            }

            if (choice == 2) {
                stack.pop();
            }

            if (choice == 3) {
                System.out.println(stack.peek().currMax);
            }
        }
    }
}

class StackNode {
    int val;
    int currMax;

    public StackNode(int val, int currMax) {
        this.val = val;
        this.currMax = currMax;
    }
}