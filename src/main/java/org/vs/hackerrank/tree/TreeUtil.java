package org.vs.hackerrank.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TreeUtil {

    public static void main(String[] args) {
        String[] split = "abc".split("");
        System.out.println(Arrays.toString(split));
    }

    //lowest common ancestor
    public static Node lca(Node root, int v1, int v2) {
        if (v1 == root.data || v2 == root.data
                || v1 < root.data && v2 > root.data
                || v1 > root.data && v2 < root.data ) {
            return root;
        }
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        } else {
            return lca(root.right, v1, v2);
        }
    }


    //huffman decoding
    static void decode(String str, Node root) {
        char[] chars = str.toCharArray();
        Node current = root;

        for (char c : chars) {
            if (c == '0') {
                current = current.left;
            }
            if (c == '1') {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                System.out.print(current.data);
                current = root;
            }
        }
    }


    public static void inOrderWithStack(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

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

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
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
