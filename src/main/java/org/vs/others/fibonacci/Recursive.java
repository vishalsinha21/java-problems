package org.vs.others.fibonacci;

public class Recursive {

    public static void main(String[] args) {
        System.out.println(getNthFibonacci(10));
    }

    public static int getNthFibonacci(int n) {
        int f;
        if (n <= 2) {
            return 1;
        }

        f = getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
        return f;
    }
}
