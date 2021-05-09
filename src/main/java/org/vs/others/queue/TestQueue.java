package org.vs.others.queue;

public class TestQueue {

    public static void main(String[] args) {
        QueueArrayShiftingImpl queue = new QueueArrayShiftingImpl(10);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue);
    }
}
