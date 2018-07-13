package org.vs.hackerrank.tree.topview;

import org.vs.hackerrank.tree.Node;
import org.vs.hackerrank.tree.TreeUtil;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = TreeUtil.insert(root, data);
        }
        scan.close();
        TreeUtil.topView(root);
    }
}
