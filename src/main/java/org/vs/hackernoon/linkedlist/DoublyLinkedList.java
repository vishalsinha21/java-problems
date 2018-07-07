package org.vs.hackernoon.linkedlist;

public class DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedListNode head = LinkedListUtil.sortedInsert(null, 2);
        head = LinkedListUtil.sortedInsert(head, 3);
        head = LinkedListUtil.sortedInsert(head, 4);
        head = LinkedListUtil.sortedInsert(head, 1);

        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        head = LinkedListUtil.reverse(head);

        current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }




    }
}
