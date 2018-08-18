package org.vs.geeksforgeeks.tree.inorder;

import org.vs.geeksforgeeks.tree.BinarySearchTree;
import org.vs.geeksforgeeks.tree.Node;

import java.util.Stack;

public class InOrderTraversal {

    public static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public static void inOrderWithoutRecursion(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            Node peek = stack.peek();

            if (peek.left != null) {
                stack.add(peek.left);
            } else {
                Node left = stack.pop();
                System.out.print(left.data + " ");
                if (!stack.isEmpty()) {
                    Node center = stack.pop();
                    System.out.print(center.data + " ");
                    if (center.right != null) {
                        stack.add(center.right);
                    }
                }
            }
        }
    }

    public static void inOrderWithoutRecursion2(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(100);
        tree.add(80);
        tree.add(150);
        tree.add(60);
        tree.add(90);
        tree.add(140);
        tree.add(200);
        tree.add(40);
        tree.add(70);

        inOrder(tree.root);
        System.out.println();
        inOrderWithoutRecursion(tree.root);
        System.out.println();
        inOrderWithoutRecursion2(tree.root);
    }
}
