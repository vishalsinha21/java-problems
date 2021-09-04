package org.vs.ctci.stackandqueue;

public class Stack {
    private Node top;
    private int min;

    public Stack() {
        this.min = Integer.MAX_VALUE;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = top;

        while (node != null) {
            sb.append(node.data).append(" ");
            node = node.next;
        }

        return sb.toString().trim();
    }
}
