package org.vs.dynamicprogramming;

import java.math.BigInteger;

//get big fibonnaci numbers using BigInteger and dynamic programming with memoization
public class FibonacciBigNumbers {

    int size = 0;
    BigInteger[] memo = null;

    public FibonacciBigNumbers(int size) {
        this.size = size;
        this.memo = new BigInteger[size];
    }

    public BigInteger fibo(int n) {
        BigInteger result;

        if (memo[n] != null) {
            return memo[n];
        }

        if (n < 2) {
            result = BigInteger.valueOf(n);
        } else {
            result = fibo(n - 1).add(fibo(n - 2));
        }

        memo[n] = result;
        return result;
    }

    public static void main(String[] args) {
        int size = 250000;
        FibonacciBigNumbers solution = new FibonacciBigNumbers(size);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            solution.fibo(i);
        }

        System.out.println("time taken: " + (System.currentTimeMillis() - start));
    }
}
