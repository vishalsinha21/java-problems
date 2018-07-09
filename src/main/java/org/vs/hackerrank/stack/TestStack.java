package org.vs.hackerrank.stack;

public class TestStack {

    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 4, 7, 10, 9};
        System.out.println(StackUtil.poisonousPlants(arr));

    }

    private static void largestRectangle() {
        int[] arr = {8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116};
        System.out.println(StackUtil.largestRectangle(arr));
    }

    private static void twoStacks() {
        int[] arr1 = {16, 17, 9, 3, 12};
        int[] arr2 = {9, 3, 4, 19, 18, 4, 1, 5, 15, 1, 12, 2, 18, 18, 2, 1, 4, 10, 4, 3, 1, 13, 0, 4, 17, 16, 14, 6, 11, 6, 6, 0, 9, 10, 12, 0, 14, 13, 5, 1, 14, 9, 4, 4};

        System.out.println(StackUtil.twoStacks(73, arr1, arr2));
    }

    private static void testEqualStacks() {
        int[] arr1 = {3, 2, 1, 1, 1};
        int[] arr2 = {4, 3, 2};
        int[] arr3 = {1, 1, 4, 1};

        System.out.println(StackUtil.equalStacks(arr1, arr2, arr3));
    }

    private static void checkIfBalanced() {
        System.out.println(StackUtil.isBalanced("{[()]}"));
        System.out.println(StackUtil.isBalanced("{[(])}"));
        System.out.println(StackUtil.isBalanced("()()()[]"));
        System.out.println(StackUtil.isBalanced(")}][(})){))[{}[}"));
        System.out.println(StackUtil.isBalanced("(("));
    }
}
