package org.vs.practice.tree;

public class BinarySearchTree {
    private TreeNode root;

    public void add(int data) {
        TreeNode node = new TreeNode(data);
        if (root == null) {
            root = node;
        } else {
            add(root, data);
        }
    }

    private TreeNode add(TreeNode node, int data) {
        if (node ==  null) {
            return new TreeNode(data);
        }

        if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }

        return node;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        print(root, sb);

        return sb.toString().trim();
    }

    private void print(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        print(node.left, sb);
        sb.append(node.data).append(" ");
        print(node.right, sb);
    }

}

