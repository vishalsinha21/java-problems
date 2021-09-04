package org.vs.ctci.list;

public class SortedLinkedList {

    private Node root;

    public void insert(int data) {
        Node temp = new Node(data, null);
        if (root == null || data < root.data) {
            temp.next = root;
            this.root = temp;
            return;
        }

        Node node = root;
        Node prev = root;
        while (node != null && data > node.data) {
            prev = node;
            node = node.next;
        }

        prev.next = temp;
        temp.next = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = root;

        while (node != null) {
            sb.append(node.data).append(" ");
            node = node.next;
        }

        return sb.toString().trim();
    }
}
