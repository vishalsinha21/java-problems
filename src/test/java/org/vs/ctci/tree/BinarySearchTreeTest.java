package org.vs.ctci.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    @Test
    void should_add_to_bst() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.inOrder();
        assertThat(tree.min()).isEqualTo(8);
        assertThat(tree.max()).isEqualTo(42);

        assertThat(tree.contains(20)).isTrue();
        assertThat(tree.contains(35)).isTrue();
        assertThat(tree.contains(8)).isTrue();
        assertThat(tree.contains(42)).isTrue();
        assertThat(tree.contains(14)).isTrue();

        assertThat(tree.contains(999)).isFalse();
        assertThat(tree.contains(0)).isFalse();
        assertThat(tree.contains(2)).isFalse();
    }

    @Test
    void should_traverse_inorder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.inOrder();
    }

    @Test
    void should_traverse_preorder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.preOrder();
    }

    @Test
    void should_traverse_postorder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.postOrder();
    }

    @Test
    void should_delete_leaf_node() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.inOrder();
        tree.delete(14);
        tree.inOrder();
    }

    @Test
    void should_delete_node_with_one_child() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.inOrder();
        tree.delete(15);
        tree.inOrder();
    }

    @Test
    void should_traverse_inorder_with_stack() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.inOrder();
        tree.inOrderWithStack();
    }

    @Test
    void should_traverse_tree_by_levels() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(12);
        tree.add(35);
        tree.add(8);
        tree.add(15);
        tree.add(42);
        tree.add(14);

        tree.printTreeByLevels();
    }

}