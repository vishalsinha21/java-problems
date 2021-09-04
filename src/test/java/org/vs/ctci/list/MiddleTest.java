package org.vs.ctci.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MiddleTest {

    @Test
    void should_find_middle_element1() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);

        assertThat(Middle.findMiddle(list.getRoot())).isEqualTo(2);
    }

    @Test
    void should_find_middle_element2() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);

        assertThat(Middle.findMiddle(list.getRoot())).isEqualTo(2);
    }

    @Test
    void should_find_middle_element3() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);

        assertThat(Middle.findMiddle(list.getRoot())).isEqualTo(3);
    }

    @Test
    void should_find_middle_element4() {
        LinkedList list = new LinkedList();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addToTail(5);
        list.addToTail(6);

        assertThat(Middle.findMiddle(list.getRoot())).isEqualTo(4);
    }

}