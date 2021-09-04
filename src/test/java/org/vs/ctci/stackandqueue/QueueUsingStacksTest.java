package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class QueueUsingStacksTest {

    @Test
    void should_add_and_remove_from_queue() {
        QueueUsingStacks queue = new QueueUsingStacks();

        IntStream.range(1, 6).forEach(queue::add);
        assertThat(queue.remove()).isEqualTo(1);
        assertThat(queue.remove()).isEqualTo(2);
        assertThat(queue.remove()).isEqualTo(3);

        IntStream.range(6, 11).forEach(queue::add);
        assertThat(queue.remove()).isEqualTo(4);
        assertThat(queue.remove()).isEqualTo(5);
        assertThat(queue.remove()).isEqualTo(6);
        assertThat(queue.remove()).isEqualTo(7);
        assertThat(queue.remove()).isEqualTo(8);
        assertThat(queue.remove()).isEqualTo(9);
        assertThat(queue.remove()).isEqualTo(10);
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> queue.remove());
    }
}