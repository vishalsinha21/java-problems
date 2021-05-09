package org.vs.others.linkedlist;

public class TestDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();

        dList.addAtHead("one");
        dList.addAtHead("two");
        dList.addAtHead("four");
        dList.add(0, "five");
        dList.add(2, "three");
        dList.add(5, "zero");

        System.out.println(dList);
        System.out.println(dList.length());
    }
}
