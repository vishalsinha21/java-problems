package org.vs.ctci.tree;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TreeUtilTest {

    @Test
    void should_return_true_if_trees_are_identical() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.add(20);
        tree2.add(12);
        tree2.add(35);
        tree2.add(8);
        tree2.add(15);
        tree2.add(42);
        tree2.add(14);

        assertThat(TreeUtil.isIdentical(tree1.getRoot(), tree2.getRoot())).isTrue();
        assertThat(TreeUtil.isIdenticalRecursive(tree1.getRoot(), tree2.getRoot())).isTrue();
    }

    @Test
    void should_return_false_if_trees_are_not_identical1() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.add(20);
        tree2.add(12);
        tree2.add(35);
        tree2.add(8);
        tree2.add(18);
        tree2.add(42);
        tree2.add(14);

        assertThat(TreeUtil.isIdentical(tree1.getRoot(), tree2.getRoot())).isFalse();
        assertThat(TreeUtil.isIdenticalRecursive(tree1.getRoot(), tree2.getRoot())).isFalse();
    }

    @Test
    void should_return_false_if_trees_are_not_identical2() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        BinarySearchTree tree2 = new BinarySearchTree();

        assertThat(TreeUtil.isIdentical(tree1.getRoot(), tree2.getRoot())).isFalse();
        assertThat(TreeUtil.isIdenticalRecursive(tree1.getRoot(), tree2.getRoot())).isFalse();
    }


    @Test
    void should_return_false_if_trees_are_not_identical3() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.add(20);
        tree2.add(12);
        tree2.add(35);

        assertThat(TreeUtil.isIdentical(tree1.getRoot(), tree2.getRoot())).isFalse();
        assertThat(TreeUtil.isIdenticalRecursive(tree1.getRoot(), tree2.getRoot())).isFalse();
    }

    @Test
    void should_return_false_if_trees_are_not_identical4() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.add(10);
        tree2.add(12);
        tree2.add(35);
        tree2.add(8);
        tree2.add(18);
        tree2.add(42);
        tree2.add(14);

        assertThat(TreeUtil.isIdentical(tree1.getRoot(), tree2.getRoot())).isFalse();
        assertThat(TreeUtil.isIdenticalRecursive(tree1.getRoot(), tree2.getRoot())).isFalse();
    }

    @Test
    void should_print_node_with_levels() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        Map<Integer, List<Integer>> map = new TreeUtil().printLevels(tree1.getRoot());

        System.out.println(map);
    }

    @Test
    void should_print_node_with_distance() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        Map<Integer, List<Integer>> map = new TreeUtil().printHorizontalDistance(tree1.getRoot());

        System.out.println(map);
    }

    @Test
    void should_print_top_view() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        new TreeUtil().topView(tree1.getRoot());
    }

    @Test
    void should_print_bottom_view() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        new TreeUtil().bottomView(tree1.getRoot());
    }

    @Test
    void should_convert_to_sum_tree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        new TreeUtil().convertToSum(root);

        System.out.println(root.data);
    }

    @Test
    void should_return_false_if_invalid_BST() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        assertThat(new TreeUtil().isValidBST(root)).isFalse();
    }

    @Test
    void should_return_true_if_valid_BST() {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.add(20);
        tree1.add(12);
        tree1.add(35);
        tree1.add(8);
        tree1.add(15);
        tree1.add(42);
        tree1.add(14);

        assertThat(new TreeUtil().isValidBST(tree1.getRoot())).isTrue();
    }

    @Test
    void should_return_true_if_valid_BST1() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20);

        assertThat(new TreeUtil().isValidBST(root)).isTrue();
    }

}