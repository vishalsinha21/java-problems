package org.vs.hackerrank.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.hackerrank.com/challenges/min-max-riddle/problem
public class MinMaxRiddle {

    public static void main(String[] args) {
        long[] arr = {10, 20, 30, 50, 10, 70, 30};
        long[] result = riddle(arr);

        System.out.println(Arrays.toString(result));
    }

    //solution given here: https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
    static long[] riddle(long[] arr) {
        int[] nextSmallerElement = getNextSmallerElementIndex(arr);
        int[] prevSmallerElement = getPrevSmallerElementIndex(arr);

        long[] temp = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int windowLength = nextSmallerElement[i] - prevSmallerElement[i] - 1;
            temp[windowLength] = Math.max(temp[windowLength], arr[i]);
        }

        for (int i = arr.length -1 ; i > 0; i--) {
            temp[i] = Math.max(temp[i], temp[i + 1]);
        }

        long[] ans = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = temp[i + 1];
        }

        return ans;
    }

    private static int[] getNextSmallerElementIndex(long[] arr) {
        int[] nextSmallerElement = new int[arr.length];
        Arrays.fill(nextSmallerElement, arr.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nextSmallerElement[stack.pop()] = i;
            }
            stack.add(i);
        }

        return nextSmallerElement;
    }

    private static int[] getPrevSmallerElementIndex(long[] arr) {
        int[] prevSmallerElement = new int[arr.length];
        Arrays.fill(prevSmallerElement, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                prevSmallerElement[stack.pop()] = i;
            }
            stack.add(i);
        }

        return prevSmallerElement;
    }

    // Add the numbers to the queue
    // Iterate queue and compare adjacent numbers and add to second queue
    // First time the window size is 2, then 3 and so on
    // Also keep track of the max in the queue,  as that will be the max for that window size
    static long[] riddleUsingQueues(long[] arr) {
        long[] result = new long[arr.length];
        Queue<Long> queue1 = new LinkedList<>();
        //add all numbers to the queue
        for (int i = 0; i < arr.length; i++) {
            queue1.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            long max = Long.MIN_VALUE;
            Queue<Long> queue2 = new LinkedList<>();

            while (queue1.size() > 1) {
                long first = queue1.remove();
                long second = queue1.peek();

                //add the minimum of adjacent 2 numbers to the second queue
                long min = Math.min(first, second);
                //keep track of max in the queue
                max = Math.max(max, first);
                queue2.add(min);
            }

            max = Math.max(max, queue1.remove());
            result[i] = max;
            queue1 = queue2;
        }

        return result;
    }
}
