package org.vs.ctci.stackandqueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortedStackTest {

    @Test
    void should_keep_smallest_on_top() {
        SortedStack sortedStack = new SortedStack();

        sortedStack.push(100);
        assertThat(sortedStack.toString()).isEqualTo("[100]");

        sortedStack.push(20);
        assertThat(sortedStack.toString()).isEqualTo("[100, 20]");
        sortedStack.push(200);
        assertThat(sortedStack.toString()).isEqualTo("[200, 100, 20]");

        assertThat(sortedStack.pop()).isEqualTo(20);


        sortedStack.push(40);
        assertThat(sortedStack.toString()).isEqualTo("[200, 100, 40]");
        sortedStack.push(80);
        assertThat(sortedStack.toString()).isEqualTo("[200, 100, 80, 40]");
        sortedStack.push(10);
        assertThat(sortedStack.toString()).isEqualTo("[200, 100, 80, 40, 10]");
        sortedStack.push(400);
        assertThat(sortedStack.toString()).isEqualTo("[400, 200, 100, 80, 40, 10]");

        assertThat(sortedStack.pop()).isEqualTo(10);
    }
}