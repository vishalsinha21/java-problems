package org.vs.geeksforgeeks.tree;

import org.vs.geeksforgeeks.tree.leftview.LeftView;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.peek();

            if (node.left == null) {
                node.left = new Node(data);
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new Node(data);
                break;
            } else {
                queue.add(node.right);
            }

            queue.remove();
        }
    }

    public void preOrder(Node node) {
        System.out.print(node.data + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
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

    public int depth(Node node) {
        return maxDepth(node) - 1;
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 1;
        }

        int leftDepth = 1 + maxDepth(node.left);
        int rightDepth = 1 + maxDepth(node.right);

        return Math.max(leftDepth, rightDepth);
    }


    public void inOrder(Node node, int depth) {
        if (node.left != null) {
            inOrder(node.left, depth + 1);
        }
        System.out.print(String.format("%d[%d] ", node.data, depth));
        if (node.right != null) {
            inOrder(node.right, depth + 1);
        }
    }

    public void levelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node peek = queue.peek();

            if (peek.left != null) {
                queue.add(peek.left);
            }

            if (peek.right != null) {
                queue.add(peek.right);
            }

            System.out.print(peek.data + " ");
            queue.remove();
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for (int i = 1; i <= 15; i++) {
            tree.add(i);
        }

        LeftView.leftViewR(tree.root);
    }

}

