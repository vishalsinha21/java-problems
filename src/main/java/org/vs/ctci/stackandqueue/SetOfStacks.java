package org.vs.ctci.stackandqueue;

import java.util.NoSuchElementException;

public class SetOfStacks {
    private int individualStackCapacity;
    private StackNode top;

    public SetOfStacks(int individualStackCapacity) {
        this.individualStackCapacity = individualStackCapacity;
    }

    public void push(int data) {
        if (top == null) {
            StackNode node = new StackNode(individualStackCapacity);
            node.push(data);
            top = node;
            return;
        }

        if (top.isFull()) {
            StackNode node = new StackNode(individualStackCapacity);
            node.push(data);
            node.setNext(top);
            top = node;
        } else {
            top.push(data);
        }
    }

    public int pop() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        int data = top.pop();
        if (top.isEmpty()) {
            top = top.getNext();
        }

        return data;
    }

    public int popAt(int index) {
        StackNode node = this.top;
        StackNode prev = this.top;

        for (int i = 0; i < index; i++) {
            prev = node;
            node = node.getNext();
        }

        int data = node.pop();
        if (node.isEmpty()) {
            prev.setNext(node.getNext());
        }

        return data;
    }

}

class StackNode {
    private int[] dataArray;
    private StackNode next;
    private int capacity;
    private int size;

    public void setNext(StackNode next) {
        this.next = next;
    }

    public StackNode getNext() {
        return next;
    }

    public StackNode(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dataArray = new int[capacity];
        this.next = null;
    }

    public void push(int data) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full!");
        }

        dataArray[size] = data;
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        size--;
        int data = dataArray[size];
        dataArray[size] = 0; //clear
        return data;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
