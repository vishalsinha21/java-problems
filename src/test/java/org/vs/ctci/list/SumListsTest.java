package org.vs.ctci.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumListsTest {

    @Test
    void should_sum_lists() {
        SumLists sumLists = new SumLists();
        LinkedList list1 = new LinkedList();
        list1.addToHead(6);
        list1.addToHead(1);
        list1.addToHead(7);

        LinkedList list2 = new LinkedList();
        list2.addToHead(2);
        list2.addToHead(9);
        list2.addToHead(5);

        Node sum = sumLists.sum(list1.getRoot(), list2.getRoot());

        Node temp = sum;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    @Test
    void should_sum_lists_recursivel() {
        SumLists sumLists = new SumLists();
        LinkedList list1 = new LinkedList();
        list1.addToTail(7);
        list1.addToTail(1);
        list1.addToTail(6);

        LinkedList list2 = new LinkedList();
        list2.addToTail(5);
        list2.addToTail(9);
        list2.addToTail(2);

        sumLists.sumRecursively(list1.getRoot(), list2.getRoot());
    }

    @Test
    void should_print_recursively() {
        LinkedList list1 = new LinkedList();
        list1.addToTail(1);
        list1.addToTail(2);
        list1.addToTail(3);

        assertThat(list1.toString()).isEqualTo("1 2 3");

        SumLists sumLists = new SumLists();
        sumLists.print(list1.getRoot());
    }
}