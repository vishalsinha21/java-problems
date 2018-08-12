package org.vs.geeksforgeeks.linkedlist;

public class LinkedList {
    public Node head;

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = head;

        while (current != null) {
            builder.append(current.data + " ");
            current = current.next;
        }

        return builder.toString();
    }

}
