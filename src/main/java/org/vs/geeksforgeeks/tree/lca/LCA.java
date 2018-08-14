package org.vs.geeksforgeeks.tree.lca;

import org.vs.geeksforgeeks.tree.BinarySearchTree;
import org.vs.geeksforgeeks.tree.Node;

public class LCA {

    public static Node findLca(Node node, int v1, int v2) {
        if ((v1 >= node.data && v2 <= node.data)
                || (v1 <= node.data && v2 >= node.data)) {
            return node;
        } else if (v1 < node.data && v2 < node.data) {
            return findLca(node.left, v1, v2);
        } else {
            return findLca(node.right, v1, v2);
        }
    }

    public static Node findRec(Node node, int data) {
        if (data == node.data) {
            return node;
        } else if (data < node.data && node.left != null) {
            return findRec(node.left, data);
        } else if (data > node.data && node.right != null) {
            return findRec(node.right, data);
        }

        return null;
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

        System.out.println(findLca(tree.root, 80, 130).data);
    }
}
