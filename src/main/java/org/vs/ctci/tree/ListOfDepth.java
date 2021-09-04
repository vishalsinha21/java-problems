package org.vs.ctci.tree;

import org.vs.ctci.list.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class ListOfDepth {

    public List<Node> createListOfDepth(TreeNode root) {
        Map<Integer, Node> mapOfDepth = new HashMap<>();

        Queue<TreeUtil.TreeNodeLevel> queue = new LinkedList();
        queue.add(new TreeUtil.TreeNodeLevel(root, 1));

        while (!queue.isEmpty()) {
            TreeUtil.TreeNodeLevel nodeLevel = queue.remove();
            Integer level = nodeLevel.level;
            TreeNode node = nodeLevel.node;

            if (mapOfDepth.containsKey(level)) {
                Node existingNode = mapOfDepth.get(level);
                Node temp = new Node(node.data, null);
                temp.next = existingNode;
                mapOfDepth.put(level, temp);
            } else {
                mapOfDepth.put(level, new Node(node.data, null));
            }

            if (node.left != null) {
                queue.add(new TreeUtil.TreeNodeLevel(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new TreeUtil.TreeNodeLevel(node.right, level + 1));
            }

        }

        return mapOfDepth.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
