package org.vs.geeksforgeeks.linkedlist.rotate;

import org.vs.geeksforgeeks.linkedlist.LinkedList;
import org.vs.geeksforgeeks.linkedlist.Node;

public class Rotator {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 5; i >= 1; i--) {
            list.addAtHead(i);
        }

        System.out.println(list);

        list.head = rotate(list.head, 2);

        System.out.println(list);
    }

    public static Node rotate(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 1;
        Node current = head;

        while (count < k && current != null) {
            count++;
            current = current.next;
        }

        if (current == null) {
            return head;
        }

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

}
