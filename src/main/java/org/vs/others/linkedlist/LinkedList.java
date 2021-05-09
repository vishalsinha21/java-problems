package org.vs.others.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node head = null;

    public void addAtHead(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean contains(String str) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(str)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public String get(int index) {
        Node current = head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.data;
    }

    public boolean delete(String str) {
        if (head.data.equals(str)) {
            head = head.next;
            return true;
        }

        Node previous = head;
        Node current = head;

        while (current != null) {
            if (current.data.equals(str)) {
                previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = head;
        while (current != null) {
            builder.append(current + " | ");
            current = current.next;
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtHead("1");
        list.addAtHead("2");
        list.addAtHead("3");
        list.addAtHead("4");
        list.addAtHead("5");

        Node four = list.head.next;
        Node one = list.head.next.next.next.next;
        one.next = four;

        Node current = list.head;

        System.out.println(hasCycle(current));
    }

    private static boolean hasCycle(Node current) {
        List<Node> nodeList = new ArrayList<>();

        while (current != null) {
            if (nodeList.contains(current)) {
                System.out.println("has cycle");
                return true;
            } else {
                nodeList.add(current);
                current = current.next;
            }
        }

        return false;
    }
}

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}