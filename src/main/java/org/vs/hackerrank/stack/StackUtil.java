package org.vs.hackerrank.stack;

import java.util.Stack;

public class StackUtil {

    static String isBalanced(String str) {
        Stack<String> stack = new Stack<>();

        for (String bracket : str.split("")) {
            switch (bracket) {
                case "{": stack.push("}"); break;
                case "[": stack.push("]"); break;
                case "(": stack.push(")"); break;
                default:
                    if (stack.empty() || !stack.peek().equals(bracket)) {
                        return "NO";
                    } else {
                        stack.pop();
                    }
            }
        }

        return stack.empty() ? "YES": "NO";
    }
}
