package org.vs.hackerrank.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedListUtil {

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode current = head;
        List list = new ArrayList();

        while (current != null) {
            if (list.contains(current)) {
                return true;
            } else {
                list.add(current);
            }

            current = current.next;
        }

        return false;
    }

    boolean hasCycleAlt1(SinglyLinkedListNode head) {
        if (head == null) return false;

        SinglyLinkedListNode hare = head;
        HashSet<SinglyLinkedListNode> nodesVisited = new HashSet<>();

        while (hare != null) {
            if (nodesVisited.contains(hare)) return true;
            nodesVisited.add(hare);
            hare = hare.next;
        }

        return false;
    }

    static boolean hasCycleAlt(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (slow != fast) {
            if (slow != null) {
                slow = slow.next;
            } else {
                return false;
            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }

        return true;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            head.prev = null;
            return head;
        }

        DoublyLinkedListNode newHead = reverse(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;

        return newHead;
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) {
            return newNode;
        } else if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            DoublyLinkedListNode rest = sortedInsert(head.next, data);
            head.next = rest;
            rest.prev = head;
            return head;
        }
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int positionFromHead = length - 1 - positionFromTail;
        current = head;
        for (int i = 0; i < positionFromHead; i++) {
            current = current.next;
        }
        return current.data;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = head;
        head = newNode;

        return head;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;

        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;

        while (current1 != null || current2 != null) {
            SinglyLinkedListNode newNode = null;
            if (current1 == null) {
                newNode = new SinglyLinkedListNode(current2.data);
                current2 = current2.next;
            } else if (current2 == null) {
                newNode = new SinglyLinkedListNode(current1.data);
                current1 = current1.next;
            } else {
                if (current1.data < current2.data) {
                    newNode = new SinglyLinkedListNode(current1.data);
                    current1 = current1.next;
                } else {
                    newNode = new SinglyLinkedListNode(current2.data);
                    current2 = current2.next;
                }
            }

            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }


    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) {
            return head;
        }

        if (position == 0) {
            head = head.next;
            return head;
        }

        SinglyLinkedListNode current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;

        while (current1 != null) {
            current2 = head2;
            while (current2 != null) {
                if (current1 == current2) {
                    return current1.data;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        return 0;
    }

    static void reversePrint(SinglyLinkedListNode node) {
        if (node.next != null) {
            reversePrint(node.next);
        }
        System.out.print(node.data + " ");
    }

    static SinglyLinkedListNode recReverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            SinglyLinkedListNode remaining = recReverse(head.next);
            head.next.next = head;
            head.next = null;
            return remaining;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedListNode preNode = null;
        SinglyLinkedListNode currNode = head;
        SinglyLinkedListNode nextNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        head = preNode;
        return head;
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        SinglyLinkedListNode nodeBeforePosition = head;
        for (int i = 0; i < position; i++) {
            nodeBeforePosition = head.next;
        }
        newNode.next = nodeBeforePosition.next;
        nodeBeforePosition.next = newNode;

        return head;
    }
}
