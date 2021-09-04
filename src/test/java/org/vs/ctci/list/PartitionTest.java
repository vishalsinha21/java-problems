package org.vs.ctci.list;

import org.junit.jupiter.api.Test;

class PartitionTest {

    @Test
    void should_partition_the_list() {
        LinkedList list = new LinkedList();
        list.addToTail(3);
        list.addToTail(5);
        list.addToTail(8);
        list.addToTail(5);
        list.addToTail(10);
        list.addToTail(2);
        list.addToTail(1);
        list.print();

        Partition partition = new Partition();
        Node newRoot = partition.partition(list.getRoot(), 5);

        list.setRoot(newRoot);
        list.print();
    }
}