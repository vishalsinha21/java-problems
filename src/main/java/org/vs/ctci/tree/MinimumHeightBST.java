package org.vs.ctci.tree;

import java.util.List;

public class MinimumHeightBST {

    //Create a binary search tree of minimum height from list of sorted integers in increasing order
    public TreeNode createTree(List<Integer> list) {
        int size = list.size();

        //base condition
        //return node if size of list is 1
        if (size == 1) {
            return new TreeNode(list.get(0));
        }


        int middleElementIndex = size / 2;
        Integer middleElement = list.get(middleElementIndex);

        TreeNode node = new TreeNode(middleElement);
        node.left = createTree(list.subList(0, middleElementIndex));
        node.right = createTree(list.subList(middleElementIndex + 1, size));

        return node;
    }
}
