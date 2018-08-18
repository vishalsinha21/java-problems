package org.vs.geeksforgeeks.tree;

public class TreeUtil {

    int countLeaves(Node node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    int diameter(Node node) {
        nodeDiameter(node, 0);
        return max;
    }

    static int max = 0;

    private int nodeDiameter(Node node, int height) {
        if (node == null) {
            return height;
        }

        int lHeight = nodeDiameter(node.left, height + 1) - 1;
        int rHeight = nodeDiameter(node.right, height + 1) - 1;

        int diameter = lHeight + rHeight + 1;
        max = Math.max(diameter, max);

        return Math.max(lHeight, rHeight);
    }


    public static boolean isSymmetric(Node root) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        inOrder(root, builder1);
        inOrderReverse(root, builder2);

        return builder1.toString().equals(builder2.toString());
    }

    private static void inOrderReverse(Node node, StringBuilder builder) {
        if (node.right != null) {
            inOrderReverse(node.right, builder);
        }
        builder.append(node.data + " ");
        if (node.left != null) {
            inOrderReverse(node.left, builder);
        }
    }

    private static void inOrder(Node node, StringBuilder builder) {
        if (node.left != null) {
            inOrder(node.left, builder);
        }
        builder.append(node.data + " ");
        if (node.right != null) {
            inOrder(node.right, builder);
        }
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node, 0) - 1;
    }

    boolean isBalanced(Node root) {
        isBalanced = true;
        getHeight(root, 0);

        return isBalanced;
    }

    static boolean isBalanced = true;

    private int getHeight(Node node, int height) {
        if (node == null) {
            return height;
        }

        int lHeight = getHeight(node.left, height + 1);
        int rHeight = getHeight(node.right, height + 1);

        isBalanced = isBalanced && !(Math.abs(lHeight - rHeight) > 1);
        return Math.max(lHeight, rHeight);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }


    public void levelOrderSpiral(Node root) {
        int maxDepth = maxDepth(root);

        System.out.print(root.data + "\n");
        boolean leftToRight = true;

        for (int i = 1; i < maxDepth; i++) {
            printLevel(root, i, leftToRight);
            leftToRight = !leftToRight;
            System.out.println();
        }
    }

    private void printLevel(Node node, int level, boolean leftToRight) {
        if (level == 0) {
            System.out.print(node.data + " ");
            return;
        }

        if (leftToRight) {
            if (node.left != null) printLevel(node.left, level - 1);
            if (node.right != null) printLevel(node.right, level - 1);
        } else {
            if (node.right != null) printLevel(node.right, level - 1);
            if (node.left != null) printLevel(node.left, level - 1);
        }

    }

    public void levelOrder(Node root) {
        int maxDepth = maxDepth(root);

        System.out.print(root.data + "\n");
        for (int i = 1; i < maxDepth; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    private void printLevel(Node node, int level) {
        if (level == 0) {
            System.out.print(node.data + " ");
            return;
        }

        if (node.left != null) printLevel(node.left, level - 1);
        if (node.right != null) printLevel(node.right, level - 1);
    }

    public int maxDepth(Node node) {
        return depth(node, 0);
    }

    private int depth(Node node, int depth) {
        if (node == null) {
            return depth;
        }

        int lDepth = depth(node.left, depth + 1);
        int rDepth = depth(node.right, depth + 1);

        return Math.max(lDepth, rDepth);
    }


    public int isBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean checkBST(Node node, int leftDataMax, int rightDataMin) {
        if (node == null) {
            return true;
        }
        if (node.data < leftDataMax && node.data > rightDataMin) {
            return false;
        }

        return checkBST(node.left, node.data, node.data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        for (int i = 1; i <= 13; i++) {
            tree.add(i);
        }

        System.out.println(new TreeUtil().countLeaves(tree.root));
    }
}
