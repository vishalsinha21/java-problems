package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class SetOfStacksTest {

    @Test
    void should_push_and_pop_as_expected() {
        SetOfStacks stacks = new SetOfStacks(3);
        IntStream.range(0,20).forEach(stacks::push);

        assertThat(stacks.pop()).isEqualTo(19);
        assertThat(stacks.pop()).isEqualTo(18);
        assertThat(stacks.pop()).isEqualTo(17);
        assertThat(stacks.pop()).isEqualTo(16);
        assertThat(stacks.pop()).isEqualTo(15);
    }

    @Test
    void should_pop_from_sub_stack() {
        SetOfStacks stacks = new SetOfStacks(3);
        IntStream.range(0,20).forEach(stacks::push);

        assertThat(stacks.popAt(5)).isEqualTo(5);
        assertThat(stacks.popAt(5)).isEqualTo(4);
        assertThat(stacks.popAt(5)).isEqualTo(3);
        assertThat(stacks.popAt(5)).isEqualTo(2);
    }
}