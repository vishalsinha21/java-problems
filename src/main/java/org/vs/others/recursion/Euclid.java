package org.vs.others.recursion;

public class Euclid {

    public static int gcd(int a, int b) {
        int large = a > b ? a : b;
        int small = a > b ? b : a;
        for (int i = small; i > 1; i--) {
            if (large % i == 0 && small % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int recursiveGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return recursiveGcd(b, a % b);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static int recursiveFactorial(int n) {
        return n == 1 ? 1 : n * recursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(gcd(14, 21));
        System.out.println(gcd(6, 8));
        System.out.println(gcd(6, 3));
        System.out.println(recursiveGcd(14, 21));
        System.out.println(recursiveGcd(6, 8));
        System.out.println(recursiveGcd(6, 3));

        System.out.println(factorial(5));
        System.out.println(recursiveFactorial(5));
        System.out.println(factorial(6));
        System.out.println(recursiveFactorial(6));
    }
}
