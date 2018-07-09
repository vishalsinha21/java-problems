package org.vs.hackerrank.stack.texteditor;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public StringBuilder builder = new StringBuilder();
    public Stack<Operation> stack = new Stack<>();

    public Solution() {
        builder = new StringBuilder();
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            int choice = scanner.nextInt();

            if (choice == 1) {
                String str = scanner.next();
                solution.insert(str, false);
            } else if (choice == 2) {
                int num = scanner.nextInt();
                solution.delete(num, false);
            } else if (choice == 3) {
                int num = scanner.nextInt();
                solution.print(num);
            } else if (choice == 4) {
                solution.undo();
            }

        }
    }

    private void undo() {
        Operation operation = stack.pop();
        if (operation.query == 1) {
            insert(operation.val, true);
        } else if (operation.query == 2) {
            delete(Integer.valueOf(operation.val), true);
        }
    }

    private void print(int num) {
        System.out.println(builder.charAt(num - 1));
    }

    private void delete(int num, boolean isUndo) {
        String str = builder.substring(builder.length() - num, builder.length());
        builder.delete(builder.length() - num, builder.length());
        if (!isUndo) {
            stack.push(new Operation(1, str));
        }
    }

    private void insert(String str, boolean isUndo) {
        builder.append(str);
        if (!isUndo) {
            stack.push(new Operation(2, String.valueOf(str.length())));
        }
    }
}

class Operation {
    int query;
    String val;

    public Operation(int query, String val) {
        this.query = query;
        this.val = val;
    }
}