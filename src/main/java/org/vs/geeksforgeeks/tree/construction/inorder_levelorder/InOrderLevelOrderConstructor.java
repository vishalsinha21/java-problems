package org.vs.geeksforgeeks.tree.construction.inorder_levelorder;

import org.vs.geeksforgeeks.tree.construction.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InOrderLevelOrderConstructor {

    public static void main(String[] args) {
        String[] in = {"4", "8", "10", "12", "14", "20", "22"};
        String[] level = {"20", "8", "22", "4", "12", "10", "14"};

        List<String> inOrder = Arrays.stream(in).collect(Collectors.toList());
        List<String> levelOrder = Arrays.stream(level).collect(Collectors.toList());

        Node root = create(inOrder, levelOrder);

        preOrder(root);
        System.out.println();
        inOrder(root);
    }

    private static Node create(List<String> inOrder, List<String> levelOrder) {
        if (inOrder.isEmpty() && levelOrder.isEmpty()) {
            return null;
        }
        if (inOrder.size() == 1 && levelOrder.size() == 1) {
            return new Node(levelOrder.get(0));
        }

        Node node = new Node(levelOrder.get(0));
        int index = inOrder.indexOf(levelOrder.get(0));


        List<String> left = inOrder.subList(0, index);
        List<String> leftLevelOrder = new ArrayList<>(levelOrder);
        leftLevelOrder.retainAll(left);

        node.left = create(left, leftLevelOrder);

        List<String> right = inOrder.subList(index + 1, inOrder.size());
        List<String> rightLevelOrder = new ArrayList<>(levelOrder);
        rightLevelOrder.retainAll(right);

        node.right = create(right, rightLevelOrder);

        return node;
    }

    public static void preOrder(Node node) {
        System.out.print(node.data + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

}


