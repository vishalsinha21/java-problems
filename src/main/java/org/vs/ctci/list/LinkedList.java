package org.vs.ctci.list;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {

    private Node root;

    public void addToTail(int data) {
        Node node = new Node(data, null);
        if (root == null) {
            this.root = node;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void addToHead(int data) {
        Node node = new Node(data, root);
        root = node;
    }

    public void deleteFromHead() {
        if (root == null) {
            throw new IllegalStateException("list is empty");
        }
        root = root.next;
    }

    public void deleteFromTail() {
        if (root == null) {
            throw new IllegalStateException("list is empty");
        }
        if (root.next == null) {
            root = null;
        } else {
            Node temp = root;
            while (temp.next.next != null) {
                temp = temp.next;
            }

            temp.next = null;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        int size = 0;
        Node temp = root;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public boolean contains(int i) {
        if (isEmpty()) {
            return false;
        }

        Node temp = root;
        while (temp != null) {
            if (temp.data == i) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public void print() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        Node temp = root;
        StringBuilder builder = new StringBuilder();
        while (temp != null) {
            builder.append(temp.data + " ");
            temp = temp.next;
        }

        return builder.toString().trim();
    }

    public void removeDuplicates() {
        Map<Integer, Integer> map = new HashMap<>();

        if (!isEmpty()) {
            Node temp = root;
            Node prev = null;
            while (temp != null) {
                if (map.containsKey(temp.data)) {
                    prev.next = temp.next;
                } else {
                    map.put(temp.data, 1);
                    prev = temp;
                }
                temp = temp.next;
            }
        }
    }

    public int getKthToLastElement(int k) {
        Node temp = root;
        Node kthNode = root;

        int count = 0;

        while (temp != null) {
            count++;
            if (count > k) {
                kthNode = kthNode.next;
            }
            temp = temp.next;
        }

        return kthNode.data;
    }

    public Node getRoot() {
        return root;
    }

    public boolean delete(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }

    public void reverse() {
        if (root == null || root.next == null) {
            return;
        }

        Node node = root;

        Node runner = node.next;
        Node prev = null;

        while (runner.next != null) {
            node.next = prev;
            prev = node;
            node = runner;
            runner = runner.next;
        }

        node.next = prev;
        runner.next = node;
        root = runner;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

