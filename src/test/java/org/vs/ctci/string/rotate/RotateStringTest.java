package org.vs.ctci.string.rotate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotateStringTest {

    @Test
    void should_rotate_string() {
        assertThat(RotateString.rotate("waterbottle", 1)).isEqualTo("ewaterbottl");
        assertThat(RotateString.rotate("abcd", 1)).isEqualTo("dabc");
        assertThat(RotateString.rotate("abcd", 2)).isEqualTo("cdab");
        assertThat(RotateString.rotate("abcd", 3)).isEqualTo("bcda");
        assertThat(RotateString.rotate("abcd", 4)).isEqualTo("abcd");
    }
}