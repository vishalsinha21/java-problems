package org.vs.geeksforgeeks.tree.leftview;

import org.vs.geeksforgeeks.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {


    static int maxLevel = 0;

    public static void leftViewR(Node node) {
        leftViewRecur(node, 1);
    }

    private static void leftViewRecur(Node node, int depth) {
        if (node == null) {
            return;
        }

        if (maxLevel < depth) {
            System.out.print(node.data + " ");
            maxLevel = depth;
        }

        leftViewRecur(node.left, depth + 1);
        leftViewRecur(node.right, depth + 1);
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

    Queue<NodeWithDepth> queue = new LinkedList();

    public void leftView(Node node) {
        int depth = depth(node);
        System.out.println("depth: " + depth);
        leftView(node, 1);

        while (!queue.isEmpty() || depth >= 1) {
            NodeWithDepth nodeWithDepth = queue.remove();
            if (nodeWithDepth.depth == depth) {
                System.out.print(nodeWithDepth.node.data + " ");
                depth--;
            }
        }
    }

    //inorder traversal and add to queue, this means add leftmost of any level first
    public void leftView(Node node, int depth) {
        if (node.left != null) {
            leftView(node.left, depth + 1);
        }
        queue.add(new NodeWithDepth(node, depth));
        if (node.right != null) {
            leftView(node.right, depth + 1);
        }
    }

    //idea is to print first node occurred on level
    public void leftView_levelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<NodeWithDepth> queue = new LinkedList<>();
        int depth = 1;
        queue.add(new NodeWithDepth(node, 1));

        while (!queue.isEmpty()) {
            NodeWithDepth peek = queue.peek();

            if (peek.depth == depth) {
                System.out.print(peek.node.data + " ");
                depth++;
            }

            if (peek.node.left != null) {
                queue.add(new NodeWithDepth(peek.node.left, peek.depth + 1));
            }

            if (peek.node.right != null) {
                queue.add(new NodeWithDepth(peek.node.right, peek.depth + 1));
            }

            queue.remove();
        }
    }
}


class NodeWithDepth {
    public Node node;
    public int depth;

    public NodeWithDepth(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}