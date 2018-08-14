package org.vs.geeksforgeeks.tree.connect;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {

    public void connectNextRight(Node root) {
        Queue<NodeWithLevel> queue = new LinkedList<>();
        Queue<NodeWithLevel> tempQueue = new LinkedList<>();
        queue.add(new NodeWithLevel(root, 0));

        while (!queue.isEmpty()) {
            NodeWithLevel peek = queue.peek();

            if (peek.node.left != null) {
                queue.add(new NodeWithLevel(peek.node.left, peek.level + 1));
            }

            if (peek.node.right != null) {
                queue.add(new NodeWithLevel(peek.node.right, peek.level + 1));
            }

            tempQueue.add(queue.remove());
        }

        while (!tempQueue.isEmpty()) {
            NodeWithLevel leftNode = tempQueue.remove();
            NodeWithLevel peek = tempQueue.peek();
            leftNode.node.nextRight = peek != null && leftNode.level == peek.level ? peek.node : null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(10);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(1);
        tree.root.right = new Node(5);
        tree.root.right.right = new Node(2);

        Connect connect = new Connect();
        connect.connectNextRight(tree.root);
    }
}

class BinaryTree {
    Node root;
}

class Node {
    public int data;
    public Node left;
    public Node right;
    public Node nextRight;

    public Node(int data) {
        this.data = data;
    }
}

class NodeWithLevel {
    public Node node;
    public int level;

    public NodeWithLevel(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}