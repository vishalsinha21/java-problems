package org.vs.hackerrank.tree;

public class BinaryTree {

    private Node root;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        addNode(root, data);
    }

    private void addNode(Node node, int data) {
        if (node.left == null) {
            node.left = new Node(data);
        } else {
            if (Math.random() % 2 == 0) addNode(node.left, data);
        }

        if (node.right == null) {
            node.right = new Node(data);
        } else {
            if (Math.random() % 2 == 0) addNode(node.right, data);
        }

        if (node.left != null && node.right != null) {
            if (Math.random() % 2 == 0) {
                addNode(node.left, data);
            } else {
                addNode(node.right, data);
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

        tree.inOrder(tree.root);
    }
}
