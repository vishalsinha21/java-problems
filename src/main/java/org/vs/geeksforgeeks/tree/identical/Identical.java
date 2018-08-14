package org.vs.geeksforgeeks.tree.identical;

import org.vs.geeksforgeeks.tree.BinaryTree;
import org.vs.geeksforgeeks.tree.Node;

public class Identical {

    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null && root2 != null) {
            return false;
        } else if (root1 != null && root2 == null) {
            return false;
        }

        if (root1.data == root2.data) {
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();

        for (int i = 1; i <= 15; i++) {
            tree1.add(i);
        }

        BinaryTree tree2 = new BinaryTree();

        for (int i = 1; i <= 15; i++) {
            tree2.add(i);
        }

        System.out.println(isIdentical(tree1.root, tree2.root));

    }
}
