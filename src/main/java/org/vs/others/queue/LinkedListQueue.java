package org.vs.others.queue;

public class LinkedListQueue {

    QNode head;
    QNode tail;

    public LinkedListQueue() {
        this.head = this.tail = null;
    }

    public void enqueue(int data) {
        QNode newNode = new QNode(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int dequeue() {
        if (head == null) {
            throw new IllegalStateException("queue is empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        QNode current = head;

        while (current != null) {
            builder.append(current.data + " ");
            current = current.next;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(6);
        queue.enqueue(7);

        System.out.println(queue);
    }

}


class QNode {
    int data;
    QNode next;

    public QNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}