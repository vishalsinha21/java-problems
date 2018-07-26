package org.vs.dynamicprogramming;

public class Fibonacci {

    static long callCount = 0;

    public static long fibonacci(long n) {
        callCount++;
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    int size = 0;
    long[] memo = null;

    public Fibonacci(int size) {
        this.size = size;
        memo = new long[size];
    }

    public long fibonacciMemo(int n) {
        long result = 0;

        if (memo[n] != 0) {
            return memo[n];
        }

        if (n < 2) {
            result = n;
        } else {
            result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        }

        memo[n] = result;
        return memo[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fibonacciWithDPMemo();
        System.out.println("Time taken by fibonacci with DP memoization: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        normalFibonacciWithRecursion();
        System.out.println("Time taken for fibonacci with recursion: " + (System.currentTimeMillis() - start));
    }

    private static void fibonacciWithDPMemo() {
        Fibonacci fib = new Fibonacci(100);
        for (int i = 0; i < 100; i++) {
            fib.fibonacciMemo(i);
            //System.out.println(format("fibonacciMemo(%d): %d", i, fib.fibonacciMemo(i)));
        }
    }

    private static void normalFibonacciWithRecursion() {
        for (int i = 0; i < 40; i++) {
            fibonacci(i);
            //System.out.println(format("fibonacci(%d): %d", i, fibonacci(i)));
        }
    }


}
