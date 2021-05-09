package org.vs.others.tree;

import java.util.Optional;

public class BinarySearchTree {

    TreeNode root;
    int size = 0;
    StringBuilder builder = new StringBuilder();

    public void add(int data) {
        root = insert(root, data);
        size++;
    }

    private TreeNode insert(TreeNode node, int data) {
        TreeNode newNode = new TreeNode(data);
        if (node == null) {
            node = newNode;
        } else if (data < node.data) {
            if (node.left == null) {
                node.left = newNode;
            } else {
                insert(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = newNode;
            } else {
                insert(node.right, data);
            }
        }
        return node;
    }

    public boolean contains(int data) {
        return find(root, data).isPresent();
    }

    public boolean delete(int data) {
        Optional<TreeNode> node = find(root, data);

        if (node.isPresent()) {
            node.get().markDelete();
            size--;
            return true;
        } else {
            return false;
        }
    }

    private Optional<TreeNode> find(TreeNode node, int data) {
        if (!node.deleted && node.data == data) {
            return Optional.of(node);
        } else if (data < node.data && node.left != null) {
            return find(node.left, data);
        } else if (data > node.data && node.right != null) {
            return find(node.right, data);
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        builder = new StringBuilder();
        print(root);
        return builder.toString();
    }

    private void print(TreeNode node) {
        if (node.left != null) {
            print(node.left);
        }
        if (!node.deleted) {
            builder.append(node.data + " ");
        }
        if (node.right != null) {
            print(node.right);
        }
    }

    boolean checkBST() {
        return checkBinary(root);
    }

    boolean checkBinary(TreeNode node) {
        boolean result = true;
        if (node.left != null) {
            if (node.left.data >= node.data) {
                result = result && false;
            } else {
                result = result && checkBinary(node.left);
            }
        }

        if (node.right != null) {
            if (node.right.data <= node.data) {
                result = result && false;
            } else {
                result = result && checkBinary(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(9);
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(12);
        tree.add(11);
        tree.add(15);
        tree.add(18);
        tree.add(1);
        tree.add(6);
        tree.add(43);
        tree.add(57);

        System.out.println(tree.size);
        System.out.println(tree);

        System.out.println(tree.contains(9));
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(11));
        System.out.println(tree.contains(99));

        tree.add(14);
        tree.add(54);
        tree.add(41);

        System.out.println(tree.size);
        System.out.println(tree);

        System.out.println(tree.delete(14));
        System.out.println(tree.size);
        System.out.println(tree);

        System.out.println(tree.delete(14));
        System.out.println(tree.size);
        System.out.println(tree);

        checkIfNotBinary();
    }

    private static void checkIfNotBinary() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(7);

        System.out.println(tree);
        System.out.println(tree.checkBST());

        tree.root.left.data = 4;
        tree.root.data = 3;
        System.out.println(tree);
        System.out.println(tree.checkBST());

    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    boolean deleted;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public void markDelete() {
        this.deleted = true;
    }
}
