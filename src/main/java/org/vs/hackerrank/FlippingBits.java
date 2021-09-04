package org.vs.hackerrank;

public class FlippingBits {

    public static void main(String[] args) {
        System.out.println(flippingBits(802743475));
    }

    public static long flippingBits(long num) {
        int max = 0;
        for (int i = 0; i < num; i++) {
            if (Math.pow(2, i) >= num) {
                max = i;
                break;
            }
        }

        int[] binary = new int[32];
        long remaining = num;

        for (int i = max; i >= 0; i--) {
            long pow = (long) Math.pow(2, i);

            if (remaining >= pow) {
                remaining = remaining - pow;
                binary[i] = 1;
            } else {
                binary[i] = 0;
            }

            System.out.println("remaining: " + remaining + " pow: " + pow);

            if (remaining == 0) {
                break;
            }
        }

        for (int i = 31; i >=0 ; i--) {
            System.out.print(binary[i]);
        }

        long sum = 0;

        System.out.println();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 0) {
                sum += Math.pow(2, i);
            }
        }

        return sum;
    }
}
