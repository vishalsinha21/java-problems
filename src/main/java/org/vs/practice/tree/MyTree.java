package org.vs.practice.tree;

public class MyTree {

    private TreeNode root;

    public MyTree(TreeNode root) {
        this.root = root;
    }

    public void print() {
        print(root);
    }

    private void print(TreeNode node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.print(node.data + " ");
        print(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        MyTree tree = new MyTree(root);
        tree.print();
    }
}
