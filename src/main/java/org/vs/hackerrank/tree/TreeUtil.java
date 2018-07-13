package org.vs.hackerrank.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    public static Node find(Node node, int data) {
        if (node == null) {
            return null;
        } else if (node.data == data) {
            return node;
        }

        if (data < node.data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

    public static void levelOrder(Node root) {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private static void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    public static void topView(Node root) {
        Node current = root.left;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.left;
        }

        System.out.print(root.data + " ");

        current = root.right;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }


    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftTreeHeight = getHeight(node.left);
            int rightTreeHeight = getHeight(node.right);

            if (leftTreeHeight > rightTreeHeight) {
                return leftTreeHeight + 1;
            } else {
                return rightTreeHeight + 1;
            }
        }
    }

    static List<Integer> list = new ArrayList<>();

    public boolean checkBST(Node root) {
        getInOrder(root);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void getInOrder(Node node) {
        if (node.left != null) {
            getInOrder(node.left);
        }

        list.add(Integer.valueOf(node.data));

        if (node.right != null) {
            getInOrder(node.right);
        }

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
