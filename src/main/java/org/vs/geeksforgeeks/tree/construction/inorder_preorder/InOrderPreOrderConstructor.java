package org.vs.geeksforgeeks.tree.construction.inorder_preorder;

import org.vs.geeksforgeeks.tree.construction.Node;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InOrderPreOrderConstructor {

    public static void main(String[] args) {
        String[] pre = {"A", "B", "D", "E", "C", "F"};
        String[] in = {"D", "B", "E", "A", "F", "C"};

        List<String> preOrder = Arrays.stream(pre).collect(Collectors.toList());
        List<String> inOrder = Arrays.stream(in).collect(Collectors.toList());

        Node root = create(preOrder, inOrder);

        preOrder(root);
        System.out.println();
        inOrder(root);
    }

    private static Node create(List<String> preOrder, List<String> inOrder) {
        if (preOrder.isEmpty() && inOrder.isEmpty()) {
            return null;
        }
        if (preOrder.size() == 1 && inOrder.size() == 1) {
            return new Node(preOrder.get(0));
        }

        Node node = new Node(preOrder.get(0));
        int index = inOrder.indexOf(preOrder.get(0));

        node.left = create(preOrder.subList(1, index + 1), inOrder.subList(0, index));
        node.right = create(preOrder.subList(index + 1, preOrder.size()), inOrder.subList(index + 1, inOrder.size()));

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


