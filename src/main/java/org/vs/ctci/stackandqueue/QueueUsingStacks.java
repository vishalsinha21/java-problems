package org.vs.ctci.stackandqueue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> inQueue;
    private Stack<Integer> outQueue;

    public QueueUsingStacks() {
        inQueue = new Stack<>();
        outQueue = new Stack<>();
    }

    public void add(int data) {
        inQueue.add(data);
    }

    public int remove() {
        if (inQueue.isEmpty() && outQueue.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (outQueue.isEmpty()) {
            while (!inQueue.isEmpty()) {
                outQueue.push(inQueue.pop());
            }
        }
        return outQueue.pop();
    }

}
