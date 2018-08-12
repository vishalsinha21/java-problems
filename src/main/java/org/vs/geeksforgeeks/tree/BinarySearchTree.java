package org.vs.geeksforgeeks.tree;

public class BinarySearchTree {

    Node root;

    public void add(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;

            while (true) {
                if (data < current.data) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }


    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
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
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(100);
        tree.insert(80);
        tree.insert(120);
        tree.insert(70);
        tree.insert(90);
        tree.insert(110);
        tree.insert(130);
        tree.insert(72);

        tree.inOrder(tree.root);
    }
}
