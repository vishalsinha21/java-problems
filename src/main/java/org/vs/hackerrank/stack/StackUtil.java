package org.vs.hackerrank.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StackUtil {


    static int poisonousPlants(int[] p) {
        List<Integer> list = Arrays.stream(p).boxed().collect(Collectors.toList());
        int size = list.size();
        int iterationCount = 0;

        while (true) {
            boolean poisonousPlantFound = false;
            for (int i = size - 1; i > 0; i--) {
                if (list.get(i) > list.get(i - 1)) {
                    list.remove(i);
                    --size;
                    poisonousPlantFound = true;
                }
            }
            if (!poisonousPlantFound) {
                break;
            }
            iterationCount++;
        }

        return iterationCount;
    }


    static long largestRectangle(int[] h) {
        long[] areas = new long[h.length];

        for (int i = 0; i < h.length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(h[i]);

            //move forward and add to stack if building height is less than min else break
            for (int j = i + 1; j < h.length; j++) {
                if (h[j] >= h[i]) {
                    stack.push(h[j]);
                } else {
                    break;
                }
            }

            //move backward and add to stack if building height is less than min else break
            for (int j = i - 1; j >= 0; j--) {
                if (h[j] >= h[i]) {
                    stack.push(h[j]);
                } else {
                    break;
                }
            }

            areas[i] = h[i] * stack.size();
        }

        return Arrays.stream(areas).max().getAsLong();
    }

    static int twoStacks(int x, int[] a, int[] b) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int sum1 = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum1 + a[i] > x) {
                break;
            }
            sum1 += a[i];
            stack1.push(a[i]);
        }

        int sum2 = 0;
        for (int i = 0; i < b.length; i++) {
            if (sum2 + b[i] > x) {
                break;
            }
            sum2 += b[i];
            stack2.push(b[i]);
        }

        int totalSum = sum1 + sum2;

        while (totalSum > x) {
            if (stack1.empty()) {
                totalSum -= stack2.pop();
            } else if (stack2.empty()) {
                totalSum -= stack1.pop();
            } else {
                if (stack1.peek() > stack2.peek()) {
                    Integer i = stack1.pop();
                    stack2.push(i);
                    totalSum -= i;
                } else {
                    Integer i = stack2.pop();
                    stack1.push(i);
                    totalSum -= i;
                }
            }
        }

        return stack1.size() + stack2.size();
    }

    private static void pushToStackWithSumOfNodesBelow(Stack<NodeWithSum> stack, int i) {
        stack.push(new NodeWithSum(i, stack.isEmpty() ? 0 : stack.peek().val + stack.peek().sum));
    }


    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<NodeWithSum> stack1 = new Stack<>();
        Stack<NodeWithSum> stack2 = new Stack<>();
        Stack<NodeWithSum> stack3 = new Stack<>();

        IntStream.range(0, h1.length).forEach(i -> pushToStackWithSum(stack1, h1[h1.length - 1 - i]));
        IntStream.range(0, h2.length).forEach(i -> pushToStackWithSum(stack2, h2[h2.length - 1 - i]));
        IntStream.range(0, h3.length).forEach(i -> pushToStackWithSum(stack3, h3[h3.length - 1 - i]));

        while (!(stack1.empty() || stack2.empty() || stack3.empty())) {
            if (stack1.peek().sum == stack2.peek().sum && stack2.peek().sum == stack3.peek().sum) {
                return stack1.peek().sum;
            }

            Stack<NodeWithSum> stackWithHighestSum = stack1.peek().sum > stack2.peek().sum
                    ? stack1.peek().sum > stack3.peek().sum ? stack1 : stack3
                    : stack2.peek().sum > stack3.peek().sum ? stack2 : stack3;

            stackWithHighestSum.pop();
        }

        return 0;
    }

    private static void pushToStackWithSum(Stack<NodeWithSum> stack, int i) {
        stack.push(new NodeWithSum(i, stack.isEmpty() ? i : i + stack.peek().sum));
    }

    static String isBalanced(String str) {
        Stack<String> stack = new Stack<>();

        for (String bracket : str.split("")) {
            switch (bracket) {
                case "{":
                    stack.push("}");
                    break;
                case "[":
                    stack.push("]");
                    break;
                case "(":
                    stack.push(")");
                    break;
                default:
                    if (stack.empty() || !stack.peek().equals(bracket)) {
                        return "NO";
                    } else {
                        stack.pop();
                    }
            }
        }

        return stack.empty() ? "YES" : "NO";
    }
}

class NodeWithSum {
    int val;
    int sum;

    public NodeWithSum(int val, int sum) {
        this.val = val;
        this.sum = sum;
    }
}
