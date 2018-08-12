package org.vs.geeksforgeeks.linkedlist.delete;

import org.vs.geeksforgeeks.linkedlist.Node;

public class DeleteNode {

    void deleteNode(Node del) {
        Node current = del;
        Node next = del.next;

        int temp = current.data;
        current.data = next.data;
        next.data = temp;

        current.next = next.next;
    }
}
