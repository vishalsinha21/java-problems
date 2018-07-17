package org.vs.hackerrank.tree;

public class BinarySearchTree {

    private Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        add(root, data);
    }

    private void add(Node node, int data) {
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

    public void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public void inOrderReverse(Node node) {
        if (node.right != null) {
            inOrderReverse(node.right);
        }
        System.out.print(node.data + " ");
        if (node.left != null) {
            inOrderReverse(node.left);
        }
    }

    public void preOrder(Node node) {
        System.out.print(node.data + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

//        tree.insert(100);
//        tree.insert(80);
//        tree.insert(150);
//        tree.insert(60);
//        tree.insert(90);
//        tree.insert(140);
//        tree.insert(200);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(85);
//        tree.insert(95);
//        tree.insert(130);
//        tree.insert(145);
//        tree.insert(180);
//        tree.insert(220);

        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);

        TreeUtil.inOrder(tree.root);
        System.out.println();
        TreeUtil.preOrder(tree.root);
        System.out.println();
        TreeUtil.postOrder(tree.root);
        System.out.println();

        TreeUtil.levelOrder(tree.root);

        System.out.println(TreeUtil.lca(tree.root, 40, 85).data);
    }
}
