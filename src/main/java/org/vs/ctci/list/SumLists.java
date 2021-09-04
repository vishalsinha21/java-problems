package org.vs.ctci.list;

public class SumLists {

    public Node sum(Node node1, Node node2) {
        int num1 = 0, num2 = 0;
        int i = 0;

        Node temp = node1;
        while (temp != null) {
            num1 += (int) Math.pow(10, i) * temp.data;
            temp = temp.next;
            i++;
        }

        temp = node2;
        i = 0;
        while (temp != null) {
            num2 += (int) Math.pow(10, i) * temp.data;
            temp = temp.next;
            i++;
        }

        System.out.println(num1);
        System.out.println(num2);

        int sum = num1 + num2;
        System.out.println(sum);

        char[] chars = String.valueOf(sum).toCharArray();
        Node newNode = null;

        for (char ch : chars) {
            temp = new Node(Integer.valueOf(String.valueOf(ch)), newNode);
            newNode = temp;
        }

        return newNode;
    }

    public void sumRecursively(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }

        sumRecursively(node1.next, node2.next);

        System.out.println(node1.data + " " + node2.data);
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }

        print(node.next);
        System.out.print(node.data + " ");
    }
}
