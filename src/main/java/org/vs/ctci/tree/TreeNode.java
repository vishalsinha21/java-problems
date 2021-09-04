package org.vs.ctci.tree;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public boolean isLeafNode() {
        return left == null && right == null;
    }

    public boolean hasOneChild() {
        return (left == null && right != null) || (left != null && right == null);
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }


}
