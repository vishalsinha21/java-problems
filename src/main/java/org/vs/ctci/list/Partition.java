package org.vs.ctci.list;

public class Partition {

    public Node partition(Node root, int x) {
        Node temp = root;
        Node head = null;
        Node tail = null;

        //Add node smaller than x to head, and rest to tail
        while (temp != null) {
            Node node = new Node(temp.data, null);
            if (temp.data < x) {
                node.next = head;
                head = node;
            } else {
                node.next = tail;
                tail = node;
            }

            temp = temp.next;
        }

        //merge head and tail
        Node tempHead = head;
        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        tempHead.next = tail;

        //return new root
        return head;
    }
}
