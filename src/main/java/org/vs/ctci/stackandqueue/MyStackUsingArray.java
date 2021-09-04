package org.vs.ctci.stackandqueue;

public class MyStackUsingArray {

    private int[] array;
    private int pointer = -1;
    private final int capacity;

    public MyStackUsingArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void push(int data) {
        pointer++;
        if (pointer == capacity) {
            throw new IllegalStateException("Stack is full!");
        }
        array[pointer] = data;
    }

    public int pop() {
        if (pointer < 0) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = array[pointer];
        pointer--;
        return data;
    }

    public int peek() {
        if (pointer < 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[pointer];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = pointer; i >= 0; i--) {
            sb.append(array[i]).append(" ");
        }

        return sb.toString().trim();
    }

}
