package org.vs.ctci.tree;

import org.junit.jupiter.api.Test;
import org.vs.ctci.list.Node;

import java.util.List;

class ListOfDepthTest {

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

        ListOfDepth listOfDepth = new ListOfDepth();
        List<Node> list = listOfDepth.createListOfDepth(tree.getRoot());

        System.out.println(list);
    }
}