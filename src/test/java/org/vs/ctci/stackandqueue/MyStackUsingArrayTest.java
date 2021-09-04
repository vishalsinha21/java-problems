package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MyStackUsingArrayTest {

    private MyStackUsingArray stack;

    @BeforeEach
    void setUp() {
        stack = new MyStackUsingArray(5);
    }

    @Test
    void should_push_elements_to_stack() {
        stack.push(3);
        stack.push(6);
        stack.push(9);

        assertThat(stack.toString()).isEqualTo("9 6 3");

        stack.push(12);
        assertThat(stack.toString()).isEqualTo("12 9 6 3");

        assertThat(stack.pop()).isEqualTo(12);
        assertThat(stack.toString()).isEqualTo("9 6 3");

        assertThat(stack.pop()).isEqualTo(9);
        assertThat(stack.toString()).isEqualTo("6 3");

        assertThat(stack.peek()).isEqualTo(6);
        assertThat(stack.toString()).isEqualTo("6 3");

        assertThat(stack.pop()).isEqualTo(6);
        assertThat(stack.toString()).isEqualTo("3");

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.toString()).isEqualTo("");

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> stack.pop());
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> stack.peek());
    }

    @Test
    void should_throw_exception_when_trying_to_push_more_elements_to_full_stack() {
        IntStream.range(1, 6).forEach(stack::push);
        assertThat(stack.toString()).isEqualTo("5 4 3 2 1");

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> stack.push(8));
    }

}