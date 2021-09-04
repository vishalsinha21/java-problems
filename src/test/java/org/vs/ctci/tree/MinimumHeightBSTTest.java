package org.vs.ctci.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

class MinimumHeightBSTTest {

    @Test
    void should_create_tree_with_min_height() {
        MinimumHeightBST minimumHeightBST = new MinimumHeightBST();

        TreeNode root = minimumHeightBST.createTree(List.of(5, 8, 13, 17, 200, 205, 300));

        new TreeUtil().printLevels(root);
    }
}