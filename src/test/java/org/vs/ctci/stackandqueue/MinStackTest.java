package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {

    @Test
    void should_return_minimum() {
        MinStack minStack = new MinStack();

        minStack.push(100);
        assertThat(minStack.minimum()).isEqualTo(100);

        minStack.push(30);
        assertThat(minStack.minimum()).isEqualTo(30);

        minStack.push(20);
        assertThat(minStack.minimum()).isEqualTo(20);

        minStack.push(200);
        assertThat(minStack.minimum()).isEqualTo(20);

        minStack.push(40);
        assertThat(minStack.minimum()).isEqualTo(20);

        minStack.push(10);
        assertThat(minStack.minimum()).isEqualTo(10);

        minStack.push(5);
        assertThat(minStack.minimum()).isEqualTo(5);

        minStack.push(400);
        assertThat(minStack.minimum()).isEqualTo(5);

        assertThat(minStack.pop()).isEqualTo(400);
        assertThat(minStack.minimum()).isEqualTo(5);

        assertThat(minStack.pop()).isEqualTo(5);
        assertThat(minStack.minimum()).isEqualTo(10);
    }
}