package org.vs.geeksforgeeks.recursion;

public class PrintConsecutiveNumbers {

    public static void main(String[] args) {
        printReverse(10);
        System.out.println();
        printForward(10);
    }

    private static void printReverse(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printReverse(n - 1);
    }

    private static void printForward(int n) {
        if (n == 0) {
            return;
        }
        printForward(n - 1);
        System.out.print(n + " ");
    }
}
