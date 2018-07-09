package org.vs.hackerrank.stack.twostacks;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    /*
     * Complete the twoStacks function below.
     */
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
                    totalSum -= stack1.pop();
                } else {
                    totalSum -= stack2.pop();
                }
            }
        }

        return stack1.size() + stack2.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp.txt"));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
