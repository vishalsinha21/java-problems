package org.vs.geeksforgeeks.tree;

public class TreeUtil {


    public void levelOrderSpiral(Node root) {
        int maxDepth = maxDepth(root);

        System.out.print(root.data + "\n");
        boolean leftToRight = true;

        for (int i = 1; i < maxDepth; i++) {
            printLevel(root, i, leftToRight);
            leftToRight = !leftToRight;
            System.out.println();
        }
    }

    private void printLevel(Node node, int level, boolean leftToRight) {
        if (level == 0) {
            System.out.print(node.data + " ");
            return;
        }

        if (leftToRight) {
            if (node.left != null) printLevel(node.left, level - 1);
            if (node.right != null) printLevel(node.right, level - 1);
        } else {
            if (node.right != null) printLevel(node.right, level - 1);
            if (node.left != null) printLevel(node.left, level - 1);
        }

    }

    public void levelOrder(Node root) {
        int maxDepth = maxDepth(root);

        System.out.print(root.data + "\n");
        for (int i = 1; i < maxDepth; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private void printLevel(Node node, int level) {
        if (level == 0) {
            System.out.print(node.data + " ");
            return;
        }

        if (node.left != null) printLevel(node.left, level - 1);
        if (node.right != null) printLevel(node.right, level - 1);
    }

    public int maxDepth(Node node) {
        return depth(node, 0);
    }

    private int depth(Node node, int depth) {
        if (node == null) {
            return depth;
        }

        int lDepth = depth(node.left, depth + 1);
        int rDepth = depth(node.right, depth + 1);

        return Math.max(lDepth, rDepth);
    }


    public int isBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean checkBST(Node node, int leftDataMax, int rightDataMin) {
        if (node == null) {
            return true;
        }
        if (node.data < leftDataMax && node.data > rightDataMin) {
            return false;
        }

        return checkBST(node.left, node.data, node.data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(5);

        new TreeUtil().levelOrderSpiral(tree.root);
    }
}
