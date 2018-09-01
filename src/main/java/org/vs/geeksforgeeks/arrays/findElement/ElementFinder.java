package org.vs.geeksforgeeks.arrays.findElement;

public class ElementFinder {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 4, 6, 7, 6, 7, 1}; //3
        System.out.println(findElementThatAppearOnceWhenAllOtherElementsAppearTwice(arr1));

        int[] arr2 = {2, 2, 2, 4, 5, 5, 5, 6, 7, 6, 6, 7, 7}; //4
        System.out.println(findElementThatAppearOnceWhenAllOtherElementsAppearThrice(arr2));
    }

    public static int findElementThatAppearOnceWhenAllOtherElementsAppearTwice(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        return result;
    }

    public static int findElementThatAppearOnceWhenAllOtherElementsAppearThrice(int[] arr) {
        int ones = 0;
        int twos = 0;
        int common_bit_mask = 0;


        for (int i = 0; i < arr.length; i++) {
            twos = twos | (ones & arr[i]);
            ones = ones ^ arr[i];

            common_bit_mask = ~(ones & twos);
            ones &= common_bit_mask;
            twos &= twos & common_bit_mask;
        }

        return ones;
    }
}
