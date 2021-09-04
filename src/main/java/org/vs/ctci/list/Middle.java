package org.vs.ctci.list;

public class Middle {

    public static int findMiddle(Node root) {
        Node slow = root;
        Node fast = root;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}
