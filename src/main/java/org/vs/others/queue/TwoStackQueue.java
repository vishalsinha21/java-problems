package org.vs.others.queue;

import java.util.Stack;

public class TwoStackQueue<T> {

    private Stack<T> inbox = new Stack<>();
    private Stack<T> outbox = new Stack<>();

    public void enqueue(T item) {
        inbox.push(item);
    }

    public T dequeue() {
        //fill outbox again only if its empty, pop from it until then
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }


    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(6);
        queue.enqueue(7);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
