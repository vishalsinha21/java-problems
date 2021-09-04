package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class QueueTest {

    @Test
    void should_test_java_queue() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        assertThat(queue.remove()).isEqualTo(1);
        assertThat(queue.remove()).isEqualTo(2);
        assertThat(queue.remove()).isEqualTo(3);
        assertThat(queue.remove()).isEqualTo(4);
        assertThat(queue.remove()).isEqualTo(5);

        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> queue.remove());
    }

}