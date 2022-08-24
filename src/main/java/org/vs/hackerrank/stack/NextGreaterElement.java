package org.vs.hackerrank.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] input = {13, 7, 6, 12};

        int[] result1 = getNextGreaterElement(input);
        IntStream.range(0, result1.length).forEach(i -> System.out.print(result1[i] + " "));
    }

    public static int[] getNextGreaterElement(int[] numbers) {
        int[] result = new int[numbers.length];
        //Initialize NGE as -1 in case there is no NGE for the given number
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            //If the current number is greater than the last number (from index) on the stack then that number is the NGE for that number
            //Pop until the stack is not empty and number is greater than last number on the stack then pop the number from stack
            while (!stack.empty() && numbers[i] > numbers[stack.peek()]) {
                result[stack.pop()] = numbers[i];
            }
            //Push current index to stack
            stack.push(i);
        }

        return result;
    }

}
