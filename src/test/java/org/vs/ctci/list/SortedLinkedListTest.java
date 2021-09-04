package org.vs.ctci.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {

    @Test
    void should_add_data_in_sorted_manner() {
        SortedLinkedList list = new SortedLinkedList();

        list.insert(2);
        assertThat(list.toString()).isEqualTo("2");

        list.insert(4);
        assertThat(list.toString()).isEqualTo("2 4");

        list.insert(1);
        assertThat(list.toString()).isEqualTo("1 2 4");

        list.insert(3);
        assertThat(list.toString()).isEqualTo("1 2 3 4");

        list.insert(10);
        assertThat(list.toString()).isEqualTo("1 2 3 4 10");

        list.insert(-2);
        assertThat(list.toString()).isEqualTo("-2 1 2 3 4 10");

        list.insert(8);
        assertThat(list.toString()).isEqualTo("-2 1 2 3 4 8 10");
    }
}