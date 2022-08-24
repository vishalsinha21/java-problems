package org.vs.practice.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void should_add_node_to_bst() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(20);
        tree.add(15);
        tree.add(22);
        tree.add(12);
        tree.add(17);
        tree.add(21);
        tree.add(24);

        assertThat(tree.print()).isEqualTo("12 15 17 20 21 22 24");
    }
}