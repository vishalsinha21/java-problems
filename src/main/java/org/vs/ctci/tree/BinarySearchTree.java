package org.vs.ctci.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void add(int data) {
        if (root == null) {
            root = new TreeNode(data);
        }
        add(root, data);
    }

    private void add(TreeNode node, int data) {
        if (data < node.data) {
            if (node.left != null) {
                add(node.left, data);
            } else {
                node.left = new TreeNode(data);
            }
        }

        if (data > node.data) {
            if (node.right != null) {
                add(node.right, data);
            } else {
                node.right = new TreeNode(data);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public int min() {
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public int max() {
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(TreeNode node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        if (data < node.data) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }

    public void delete(int data) {
        TreeNode node = root;
        TreeNode parent = root;
        boolean isLeftNode = false;

        while (node != null && node.data != data) {
            parent = node;
            isLeftNode = data < node.data;
            node = data < node.data ? node.left : node.right;
        }

        if (node == null) {
            return;
        }

        if (node.isLeafNode()) {
            if (node == root) {
                root = null;
                return;
            }

            if (isLeftNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }

        if (node.hasOneChild()) {
            if (node == root) {
                root = root.hasLeftChild() ? root.left : root.right;
            } else if (isLeftNode) {
                parent.left = node.hasLeftChild() ? node.left : node.right;
            } else {
                parent.right = node.hasLeftChild() ? node.left : node.right;
            }
            return;
        }
    }

    public void inOrderWithStack() {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            System.out.print(node.data + " ");
            current = node.right;
        }
    }

    public void printTreeByLevels() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }
}
