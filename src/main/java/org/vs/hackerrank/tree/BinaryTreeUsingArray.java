package org.vs.hackerrank.tree;

import java.util.Arrays;

public class BinaryTreeUsingArray {

    private int capacity = 0;
    int[] tree = null;
    int size = 0;

    public BinaryTreeUsingArray(int capacity) {
        this.capacity = capacity;
        tree = new int[capacity];
    }

    public void insert(int data) {
        tree[size] = data;
        size++;
    }

    public String toString() {
        return Arrays.toString(tree);
    }

    public static void main(String[] args) {
        BinaryTreeUsingArray tree = new BinaryTreeUsingArray(20);

        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }

        System.out.println(tree);
    }
}
