package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void should_add_to_stack() {
        IntStream.range(1, 6).forEach(i -> stack.push(i));

        assertThat(stack.toString()).isEqualTo("5 4 3 2 1");

        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.toString()).isEqualTo("4 3 2 1");

        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.toString()).isEqualTo("1");

        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.toString()).isEqualTo("");

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> stack.pop());
    }

    @Test
    void should_test_java_stack() {
        java.util.Stack<Integer> integerStack = new java.util.Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        assertThat(integerStack.toString()).isEqualTo("[1, 2, 3, 4, 5]");

        assertThat(integerStack.pop()).isEqualTo(5);
    }
}