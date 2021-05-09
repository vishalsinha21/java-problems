package org.vs.others.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestJavaQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList();

        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");

        System.out.println(queue);

        System.out.println(queue.peek()); //checks head without removing it
        System.out.println(queue);

        System.out.println(queue.element()); //same as peek but throws exception if queue is empty
        System.out.println(queue);

        System.out.println(queue.poll()); //retrieves and removes head
        System.out.println(queue);

        System.out.println(queue.remove()); //same as poll but can throw exception if queue is empty
        System.out.println(queue);
    }

}

