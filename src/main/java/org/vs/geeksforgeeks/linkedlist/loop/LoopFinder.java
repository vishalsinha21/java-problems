package org.vs.geeksforgeeks.linkedlist.loop;

import org.vs.geeksforgeeks.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

public class LoopFinder {

    int removeTheLoop(Node node) {
        if (node == null || node.next == null) {
            return 0;
        }

        Node prev = node;
        Node current = node.next;

        List<Node> list = new ArrayList<>();

        while (current != null) {
            if (list.contains(current)) {
                prev.next = null;
                return 1;
            } else {
                list.add(current);
            }

            prev = prev.next;
            current = current.next;
        }

        return 0;
    }

    int detectLoop(Node head) {
        if (head == null || head.next == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return 0;
            }

            if (slow == fast) {
                return 1;
            }
        }

        return 0;
    }
}
