package org.vs.others.queue;

import java.util.Arrays;


/*
This implementation of queue shifts the array elements on dequeue operation,
hence its not a very good implementation in terms of performance
*/
public class QueueArrayShiftingImpl {

    private int[] arr = null;
    private int tail = -1;

    public QueueArrayShiftingImpl(int capacity) {
        arr = new int[capacity];
    }

    public void enqueue(int data) {
        tail++;
        arr[tail] = data;
    }

    public int peek() {
        return arr[0];
    }

    public int dequeue() {
        int data = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = 0;
        tail--;

        return data;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
