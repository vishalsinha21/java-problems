package org.vs.ctci.stackandqueue;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> normal;
    private Stack<Integer> min;

    public MinStack() {
        this.normal = new Stack();
        this.min = new Stack();
    }

    public void push(int data) {
        normal.push(data);
        min.push(min.isEmpty() ? data : Math.min(data, min.peek()));
    }

    public int pop() {
        Integer data = normal.pop();
        min.pop();
        return data;
    }

    public int minimum() {
        return min.peek();
    }

}
