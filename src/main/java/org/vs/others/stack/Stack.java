package org.vs.others.stack;

import java.util.Arrays;

public class Stack {

    private int[] arr = null;
    private int top = -1;

    public Stack(int capacity) {
        this.arr = new int[capacity];
    }

    public void push(int data) {
        if (top == arr.length - 1) {
            throw new IllegalStateException("stack capacity is full");
        }
        top++;
        arr[top] = data;
    }

    public int peek() {
        if (top < 0) {
            throw new IllegalStateException("stack is empty");
        }
        return arr[top];
    }

    public int pop() {
        if (top < 0) {
            throw new IllegalStateException("stack is empty");
        }
        int data = arr[top];
        arr[top] = 0;
        top--;
        return data;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
