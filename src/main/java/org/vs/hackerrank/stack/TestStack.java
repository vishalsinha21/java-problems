package org.vs.hackerrank.stack;

public class TestStack {

    public static void main(String[] args) {
        System.out.println(StackUtil.isBalanced("{[()]}"));
        System.out.println(StackUtil.isBalanced("{[(])}"));
        System.out.println(StackUtil.isBalanced("[()][{}()][](){}([{}(())([[{}]])][])[]([][])(){}{{}{[](){}}}()[]({})[{}{{}([{}][])}]"));
        System.out.println(StackUtil.isBalanced("()()()[]"));
        System.out.println(StackUtil.isBalanced(")}][(})){))[{}[}"));
        System.out.println(StackUtil.isBalanced("(("));
    }
}
