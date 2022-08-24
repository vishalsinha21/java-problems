package org.vs.others.fibonacci;

public class Simple {

    public static void main(String[] args) {
        fibonacci(10);

        System.out.println(getNthFibonacciNumber(10));
    }

    //print n fibonacci numbers
    public static void fibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        System.out.print(a + " " + b + " ");
        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static int getNthFibonacciNumber(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
