package org.vs.ctci.list;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void should_add_data_to_tail_of_list() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);

        assertThat(list.toString()).isEqualTo("1 2 3");
    }

    @Test
    void should_add_data_to_head_of_list() {
        LinkedList list = new LinkedList();
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);

        assertThat(list.toString()).isEqualTo("3 2 1");
    }

    @Test
    void should_return_size_of_list() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);

        assertThat(list.size()).isEqualTo(3);

        list.addToHead(4);

        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    void should_delete_from_tail_and_head() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);

        assertThat(list.toString()).isEqualTo("1 2 3");

        list.deleteFromHead();
        assertThat(list.toString()).isEqualTo("2 3");

        list.deleteFromTail();
        assertThat(list.toString()).isEqualTo("2");
    }

    @Test
    void should_check_if_list_contains_given_data() {
        LinkedList list = new LinkedList();
        assertThat(list.isEmpty()).isTrue();

        list.addToTail(1);
        assertThat(list.isEmpty()).isFalse();

        list.addToTail(2);
        list.addToTail(3);
        assertThat(list.contains(4)).isFalse();

        list.addToTail(4);
        assertThat(list.contains(4)).isTrue();
    }

    @Test
    void should_remove_duplicates() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(1);

        list.removeDuplicates();

        assertThat(list.toString()).isEqualTo("1");
    }

    @Test
    void should_remove_duplicates2() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(3);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(4);
        list.addToTail(3);

        list.removeDuplicates();

        assertThat(list.toString()).isEqualTo("1 2 3 4");
    }

    @Test
    void should_get_kth_node() {
        LinkedList list = new LinkedList();
        IntStream.range(1, 10).forEach(i -> list.addToTail(i));

        assertThat(list.toString()).isEqualTo("1 2 3 4 5 6 7 8 9");

        assertThat(list.getKthToLastElement(1)).isEqualTo(9);
        assertThat(list.getKthToLastElement(2)).isEqualTo(8);
        assertThat(list.getKthToLastElement(3)).isEqualTo(7);
    }

    @Test
    void should_delete_input_node() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);

        Node thirdNode = list.getRoot().next.next;

        list.delete(thirdNode);

        assertThat(list.toString()).isEqualTo("1 2 4 5 6");
    }

    @Test
    void should_reverse_the_list() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);

        assertThat(list.toString()).isEqualTo("1 2 3 4 5");

        list.reverse();
        assertThat(list.toString()).isEqualTo("5 4 3 2 1");
    }

    @Test
    void should_reverse_list_with_1_element1() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        assertThat(list.toString()).isEqualTo("1");

        list.reverse();
        assertThat(list.toString()).isEqualTo("1");
    }

    @Test
    void should_reverse_list_with_2_elements() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        assertThat(list.toString()).isEqualTo("1 2");

        list.reverse();
        assertThat(list.toString()).isEqualTo("2 1");
    }
}