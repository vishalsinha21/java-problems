package org.vs.geeksforgeeks.tree;

public class TreeUtil {

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

        tree.root = new Node(20);
        tree.root.left = new Node(10);
        tree.root.left.left = new Node(5);
        tree.root.left.left.left = new Node(1);
        tree.root.left.left.left.right = new Node(50);

        System.out.println(new TreeUtil().isBST(tree.root));
    }
}
