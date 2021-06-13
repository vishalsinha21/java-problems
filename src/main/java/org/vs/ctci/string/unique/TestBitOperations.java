package org.vs.ctci.string.unique;

public class TestBitOperations {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(14));
        System.out.println(~14);

        doubleTheNum();
        halfTheNum();

        System.out.println(isEven(5));
        System.out.println(isEven(4));

        System.out.println(toggleCase("hello"));
        System.out.println(toggleCase("Hello"));

        System.out.println("count:"+ countBit(4));
        System.out.println("count:"+ countBit(7));
    }

    private static void halfTheNum() {
        System.out.println(14 >> 1);
        System.out.println(14 >> 2);
        System.out.println(14 >> 3);
    }

    private static void doubleTheNum() {
        System.out.println(7 << 1);
        System.out.println(7 << 2);
        System.out.println(7 << 3);
    }

    private static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    private static String toggleCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= 32;
        }
        return String.valueOf(chars);
    }

    private static int countBit(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
