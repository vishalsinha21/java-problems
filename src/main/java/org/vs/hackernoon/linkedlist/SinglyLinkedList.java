package org.vs.hackernoon.linkedlist;

public class SinglyLinkedList {

    SinglyLinkedListNode head;

    public void addAtHead(int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public String toString() {
        SinglyLinkedListNode current = head;
        StringBuilder builder = new StringBuilder();

        while (current != null) {
            builder.append(current.data + " ");
            current = current.next;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 1; i <= 5; i++) {
            list.addAtHead(i);
        }
        System.out.println(list);

        list.head = LinkedListUtil.recReverse(list.head);
        System.out.println(list);
        list.head = LinkedListUtil.reverse(list.head);
        System.out.println(list);
    }
}


class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }
}