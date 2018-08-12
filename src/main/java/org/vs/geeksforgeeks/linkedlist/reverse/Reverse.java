package org.vs.geeksforgeeks.linkedlist.reverse;

import org.vs.geeksforgeeks.linkedlist.LinkedList;
import org.vs.geeksforgeeks.linkedlist.Node;

public class Reverse {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            list.addAtHead(i);
        }

        System.out.println(list);

        list.head = reverse(list.head);

        System.out.println(list);
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = head;
        Node current = head.next;

        head.next = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
