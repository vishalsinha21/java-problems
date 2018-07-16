package org.vs.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;
    private Queue<Node> queue = new LinkedList();
    private Queue<NodeWithParent> queueP = new LinkedList();

    private void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.peek();

            if (node.left == null) {
                node.left = newNode;
                break;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = newNode;
                break;
            } else {
                queue.add(node.right);
            }

            queue.remove();
        }

    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftTreeHeight = getHeight(root.left);
            int rightTreeHeight = getHeight(root.left);

            if (leftTreeHeight > rightTreeHeight) {
                return leftTreeHeight + 1;
            } else {
                return rightTreeHeight + 1;
            }
        }
    }

    public void delete(int data) {
        Node nodeToDelete = find(data);

        if (nodeToDelete != null) {
            Node deepestRightMostNode = findDeepestRightMostNode();

            int temp = nodeToDelete.data;
            nodeToDelete.data = deepestRightMostNode.data;
            deepestRightMostNode.data = temp;
        }

        deleteRightMostNode();
    }

    private void deleteRightMostNode() {
        NodeWithParent nodeWithParent = null;

        queueP.add(new NodeWithParent(root, null));
        while(!queueP.isEmpty()) {
            nodeWithParent = queueP.peek();

            if (nodeWithParent.node.left != null) {
                queueP.add(new NodeWithParent(nodeWithParent.node.left, nodeWithParent.node));
            }
            if (nodeWithParent.node.right != null) {
                queueP.add(new NodeWithParent(nodeWithParent.node.right, nodeWithParent.node));
            }

            queueP.remove();
        }

        if (nodeWithParent.node == nodeWithParent.parent.left) {
            nodeWithParent.parent.left = null;
        } else {
            nodeWithParent.parent.right = null;
        }

    }

    public Node find(int data) {
        if (root == null) {
            return null;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            if (node.data == data) {
                return node;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            queue.remove();
        }

        return null;
    }

    public Node findDeepestRightMostNode() {
        if (root == null) {
            return root;
        }

        queue.add(root);
        Node node = null;

        while (!queue.isEmpty()) {
            node = queue.peek();

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            queue.remove();
        }

        return node;
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
        for (int i = 1; i <= 14; i++) {
            tree.insert(i);
        }

        TreeUtil.levelOrder(tree.root);
        tree.delete(2);
        TreeUtil.levelOrder(tree.root);

    }

    class NodeWithParent {
        Node node;
        Node parent;

        public NodeWithParent(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
