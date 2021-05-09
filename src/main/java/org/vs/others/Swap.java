package org.vs.others;

public class Swap {

    public static void main(String[] args) {
        //doesnt works
        swapInts();
        System.out.println("---------------");
        //doesnt works
        swapIntArrays();
        System.out.println("---------------");

        //works
        swapArrays();
    }

    private static void swapArrays() {
        int[] arr = {1, 2};

        swap(arr, 0, 1);

        System.out.println("arr[0]: " + arr[0]);
        System.out.println("arr[1]: " + arr[1]);
    }

    private static void swap(int[] arr, int aIndex, int bIndex) {
        int temp = 0;
        temp = arr[bIndex];
        arr[bIndex] = arr[aIndex];
        arr[aIndex] = temp;
    }

    private static void swapIntArrays() {
        int[] arr = {1, 2};

        swap(arr[0], arr[1]);

        System.out.println("arr[0]: " + arr[0]);
        System.out.println("arr[1]: " + arr[1]);
    }

    private static void swapInts() {
        int a = 1;
        int b = 2;

        swap(a, b);

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static void swap(int a, int b) {
        int temp = 0;

        temp = b;
        b = a;
        a = temp;
    }
}
