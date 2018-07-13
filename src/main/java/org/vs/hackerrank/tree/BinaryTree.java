package org.vs.hackerrank.tree;

public class BinaryTree {

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else {
            if (node.left == null) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftTreeHeight = getHeight(root.left);
            int rightTreeHeight = getHeight(root.left);

            if (leftTreeHeight > rightTreeHeight) {
                return leftTreeHeight + 1;
            } else {
                return rightTreeHeight + 1;
            }
        }
    }

    public void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(45);
        tree.insert(32);
        tree.insert(65);
        tree.insert(12);
        tree.insert(87);
        tree.insert(43);
        tree.insert(5);
        tree.insert(90);

        TreeUtil.levelOrder(tree.root);
    }
}
