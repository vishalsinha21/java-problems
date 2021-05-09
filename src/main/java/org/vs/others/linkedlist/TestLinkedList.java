package org.vs.others.linkedlist;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead("one");
        linkedList.addAtHead("two");
        linkedList.addAtHead("three");
        linkedList.addAtHead("four");
        linkedList.addAtHead("five");

        System.out.println(linkedList);
        System.out.println("length: " + linkedList.length());
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.contains("two")); //true
        System.out.println(linkedList.contains("five")); //true
        System.out.println(linkedList.contains("one")); //true
        System.out.println(linkedList.contains("eight")); //false

        System.out.println(linkedList.delete("five"));
        System.out.println(linkedList);
        System.out.println(linkedList.delete("three"));
        System.out.println(linkedList);
        System.out.println(linkedList.delete("one"));
        System.out.println(linkedList);
        System.out.println(linkedList.delete("eight"));
        System.out.println(linkedList);
    }
    
}
