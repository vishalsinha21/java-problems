package org.vs.geeksforgeeks.tree.level;

import org.vs.geeksforgeeks.tree.BinaryTree;
import org.vs.geeksforgeeks.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderSpiral {

    public static void printSpiral(Node node) {
        Queue<NodeWithLevel> tempQueue = new LinkedList<>();
        Queue<NodeWithLevel> queue = new LinkedList<>();
        Stack<NodeWithLevel> stack = new Stack<>();

        tempQueue.add(new NodeWithLevel(node, 0));

        while (!tempQueue.isEmpty()) {
            NodeWithLevel nodeWithLevel = tempQueue.remove();

            if (nodeWithLevel.node.left != null) {
                tempQueue.add(new NodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level + 1));
            }
            if (nodeWithLevel.node.right != null) {
                tempQueue.add(new NodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level + 1));
            }

            queue.add(nodeWithLevel);
        }


        while (!queue.isEmpty()) {
            NodeWithLevel peek = queue.peek();

            if (peek.level == 0 || peek.level % 2 == 1) {
                while (!stack.empty()) {
                    System.out.print(stack.pop().node.data + " ");
                }
                System.out.print(queue.remove().node.data + " ");
            } else {
                stack.add(queue.remove());
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().node.data + " ");
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        for (int i = 1; i <= 31; i++) {
            tree.add(i);
        }

        printSpiral(tree.root);
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