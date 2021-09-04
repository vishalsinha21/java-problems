package org.vs.ctci.stackandqueue;

import java.util.Stack;

public class SortedStack {

    private Stack<Integer> sorted;
    private Stack<Integer> temp;

    public SortedStack() {
        sorted = new Stack<>();
        temp = new Stack<>();
    }

    public void push(Integer data) {
        if (sorted.isEmpty() || data <= sorted.peek()) {
            sorted.push(data);
            return;
        }

        while (!sorted.isEmpty() && data > sorted.peek()) {
            temp.push(sorted.pop());
        }

        sorted.push(data);
        while (!temp.isEmpty()) {
            sorted.push(temp.pop());
        }
    }


    public Integer pop() {
        return sorted.pop();
    }

    public Integer peek() {
        return sorted.peek();
    }

    public boolean isEmpty() {
        return sorted.isEmpty();
    }

    @Override
    public String toString() {
        return sorted.toString();
    }

}
