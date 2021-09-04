package org.vs.ctci.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeUtil {

    public static boolean isIdentical(TreeNode root1, TreeNode root2) {
        TreeNode node1 = root1;
        TreeNode node2 = root2;

        //null checks
        if (root1 == null && root2 == null) {
            return true;
        }

        //quick and simple checks
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(node1);
        queue2.add(node2);

        //perform BFS for both trees, and return flase if any node is found not equal
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode temp1 = queue1.remove();
            TreeNode temp2 = queue2.remove();

            if (temp1.data != temp2.data) {
                return false;
            }

            if (temp1.left != null) {
                queue1.add(temp1.left);
            }
            if (temp1.right != null) {
                queue1.add(temp1.right);
            }

            if (temp2.left != null) {
                queue2.add(temp2.left);
            }
            if (temp2.right != null) {
                queue2.add(temp2.right);
            }

            //not point in going further if queue size differs at any point
            if (queue1.size() != queue2.size()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isIdenticalRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        return (root1 != null && root2 != null) && (root1.data == root2.data)
                && isIdenticalRecursive(root1.left, root2.left)
                && isIdenticalRecursive(root1.right, root2.right);
    }

    public Map<Integer, List<Integer>> printLevels(TreeNode root) {
        TreeNode node = root;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNodeLevel> queue = new LinkedList<>();

        queue.add(new TreeNodeLevel(node, 0));

        while (!queue.isEmpty()) {
            TreeNodeLevel temp = queue.remove();
            System.out.println(temp);

            if (map.containsKey(temp.level)) {
                map.get(temp.level).add(temp.node.data);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(temp.node.data);
                map.put(temp.level, list);
            }

            if (temp.node.left != null) {
                queue.add(new TreeNodeLevel(temp.node.left, temp.level + 1));
            }
            if (temp.node.right != null) {
                queue.add(new TreeNodeLevel(temp.node.right, temp.level + 1));
            }
        }

        return map;
    }

    public Map<Integer, List<Integer>> printHorizontalDistance(TreeNode root) {
        TreeNode node = root;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNodeDistance> queue = new LinkedList<>();

        queue.add(new TreeNodeDistance(node, 0));

        while (!queue.isEmpty()) {
            TreeNodeDistance temp = queue.remove();
            System.out.println(temp);

            if (map.containsKey(temp.horizontalDistance)) {
                map.get(temp.horizontalDistance).add(temp.node.data);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(temp.node.data);
                map.put(temp.horizontalDistance, list);
            }

            if (temp.node.left != null) {
                queue.add(new TreeNodeDistance(temp.node.left, temp.horizontalDistance - 1));
            }
            if (temp.node.right != null) {
                queue.add(new TreeNodeDistance(temp.node.right, temp.horizontalDistance + 1));
            }
        }

        return map;
    }

    public void topView(TreeNode root) {
        Map<Integer, List<Integer>> map = printHorizontalDistance(root);

        map.keySet().stream().sorted().forEach(i -> System.out.print(map.get(i).get(0) + " "));
    }

    public void bottomView(TreeNode root) {
        Map<Integer, List<Integer>> map = printHorizontalDistance(root);

        map.keySet().stream().sorted().forEach(i -> {
            List<Integer> list = map.get(i);
            System.out.print(list.get(list.size() - 1) + " ");
        });
    }

    public int convertToSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = convertToSum(node.left);
        int right = convertToSum(node.right);

        int old = node.data;
        node.data = left + right;

        return node.data + old;
    }

    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left != null) {
            if (node.data < node.left.data) {
                return false;
            }
        }

        if (node.right != null) {
            if (node.data > node.right.data) {
                return false;
            }
        }

        return isValidBST(node.left) && isValidBST(node.right);
    }

    static class TreeNodeLevel {
        public TreeNode node;
        public Integer level;

        public TreeNodeLevel(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }

        @Override
        public String toString() {
            return "data=" + node.data + ", level=" + level;
        }
    }

    class TreeNodeDistance {
        public TreeNode node;
        public Integer horizontalDistance;

        public TreeNodeDistance(TreeNode node, Integer horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }

        @Override
        public String toString() {
            return "data=" + node.data + ", horizontalDistance=" + horizontalDistance;
        }
    }
}
