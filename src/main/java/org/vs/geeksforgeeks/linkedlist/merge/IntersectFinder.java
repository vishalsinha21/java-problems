package org.vs.geeksforgeeks.linkedlist.merge;

import org.vs.geeksforgeeks.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

public class IntersectFinder {

    int intersectPoint(Node headA, Node headB) {
        List<Node> list = new ArrayList<>();
        Node currentA = headA;
        Node currentB = headB;

        while (currentA != null) {
            list.add(currentA);
            currentA = currentA.next;
        }

        while (currentB != null) {
            if (list.contains(currentB)) {
                return currentB.data;
            }
            currentB = currentB.next;
        }

        return -1;
    }

}
