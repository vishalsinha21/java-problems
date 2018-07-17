package org.vs.hackerrank.tree;

public class PrintPostOrder {

    static int preIndex = 0;

    void printPostOrder(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return;
        }

        int inIndex = search(inOrder, inStart, inEnd, preOrder[preIndex++]);
        // traverse left tree
        printPostOrder(inOrder, preOrder, inStart, inIndex - 1);
        // traverse right tree
        printPostOrder(inOrder, preOrder, inIndex + 1, inEnd);

        // print root node at the end of traversal
        System.out.print(inOrder[inIndex] + " ");

    }

    int search(int[] in, int startIn, int endIn, int data) {
        int i = 0;
        for (i = startIn; i < endIn; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return i;
    }

    public static void main(String ars[]) {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int len = in.length;

        PrintPostOrder tree = new PrintPostOrder();
        tree.printPostOrder(in, pre, 0, len - 1);

    }
}
