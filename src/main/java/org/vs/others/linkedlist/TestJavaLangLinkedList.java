package org.vs.others.linkedlist;

import java.util.LinkedList;

public class TestJavaLangLinkedList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add(1, "3");
        list.addFirst("5");
        list.addLast("6");
        list.push("7");
        list.pop();
        list.remove(); //same as pop
        list.remove(2);

        System.out.println(list);
    }
}
