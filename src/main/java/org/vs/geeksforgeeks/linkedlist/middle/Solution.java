package org.vs.geeksforgeeks.linkedlist.middle;

import org.vs.geeksforgeeks.linkedlist.LinkedList;
import org.vs.geeksforgeeks.linkedlist.Node;

public class Solution {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 6; i++) {
            list.addAtHead(i);
        }

        System.out.println(list);

        System.out.println(getMiddleWithCounter(list.head));
    }


    static int getMiddleWithCounter(Node head) {
        if (head == null) {
            return -1;
        }

        int count = 0;
        Node mid = head;
        Node current = head.next;

        while(current != null) {
            if (count % 2 == 0) {
                mid = mid.next;
            }
            count++;
            current = current.next;
        }

        return mid.data;
    }

    //uses fast and slow pointer, only 1 iteration :)
    static int getMiddle(Node head) {
        if (head == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
        }

        return slow.data;
    }

    static int getMiddleWithTwoIterations(Node head) {
        if (head == null) {
            return -1;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        current = head;
        int middle = count / 2;
        for (int i = 0; i < middle; i++) {
            current = current.next;
        }
        return current.data;
    }

}
