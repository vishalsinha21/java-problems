package org.vs.ctci.stackandqueue;

public class Queue {
    private Node first;
    private Node last;

    public void add(int data) {
        Node node = new Node(data);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public int remove() {
        if (first == null) {
            throw new IllegalStateException();
        }
        int data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }
        return data;
    }

    public int peek() {
        if (first == null) {
            throw new IllegalStateException();
        }
        return first.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;

        while (node != null) {
            sb.append(node.data).append(" ");
            node = node.next;
        }

        return sb.toString().trim();
    }
}
