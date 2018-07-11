package org.vs.hackerrank.tree;

public class TreeUtil {

    public boolean checkBST(Node root) {
        return isBST(root);
    }

    private boolean isBST(Node node) {
        if (node.left != null) {
            if (node.left.data > node.data) {
                return false;
            } else {
                return true && isBST(node.left);
            }
        }

        if (node.right != null) {
            if (node.right.data < node.data) {
                return false;
            } else {
                return true && isBST(node.right);
            }
        }

        return true;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        add(root, data);
        return root;
    }

    public static void add(Node node, int data) {
        if (data < node.data) {
            if (node.left != null) {
                add(node.left, data);
            } else {
                Node newNode = new Node(data);
                node.left = newNode;
            }
        } else {
            if (node.right != null) {
                add(node.right, data);
            } else {
                Node newNode = new Node(data);
                node.right = newNode;
            }
        }
    }

    public static void inOrder(Node root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }


}
