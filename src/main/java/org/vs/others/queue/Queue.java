package org.vs.others.queue;

import java.util.Arrays;

//circular queue implementation, head and tail moves forward and then in circular fashion
public class Queue {

    private int head, tail, size, capacity;
    private int[] arr = null;

    public Queue(int capacity) {
        size = 0;
        head = -1;
        tail = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void enqueue(int data) {
        if (size == capacity) {
            throw new IllegalStateException("queue is full");
        }
        if (size == 0) {
            head++;
        }

        tail = (tail + 1) % capacity;
        arr[tail] = data;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("queue is empty");
        }

        int data = arr[head];
        arr[head] = 0;
        size--;
        head = (head + 1) % capacity;
        return data;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue);

        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);
        System.out.println(queue);
    }
}
