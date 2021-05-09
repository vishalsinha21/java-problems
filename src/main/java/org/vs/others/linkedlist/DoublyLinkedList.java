package org.vs.others.linkedlist;

public class DoublyLinkedList {

    DoubleLinkedNode head;

    public void addAtHead(String data) {
        DoubleLinkedNode newNode = new DoubleLinkedNode(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void add(int index, String data) {
        if (index > length()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addAtHead(data);
        } else {
            addAtIndex(index, data);
        }

    }

    private void addAtIndex(int index, String data) {
        DoubleLinkedNode newNode = new DoubleLinkedNode(data);
        DoubleLinkedNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        if (current.next != null) {
            newNode.next = current.next;
            current.next.prev = newNode;
        }
        newNode.prev = current;
        current.next = newNode;
    }

    public int length() {
        DoubleLinkedNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DoubleLinkedNode current = head;
        while (current != null) {
            builder.append(current + " | ");
            current = current.next;
        }
        return builder.toString();
    }
}


class DoubleLinkedNode {
    String data;
    DoubleLinkedNode prev;
    DoubleLinkedNode next;

    public DoubleLinkedNode(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}