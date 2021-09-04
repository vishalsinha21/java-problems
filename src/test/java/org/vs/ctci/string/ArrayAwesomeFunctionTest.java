package org.vs.ctci.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayAwesomeFunctionTest {

    @Test
    void should_return_true_if_array_rotation_is_present() {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 1, 2};

        assertThat(ArrayAwesomeFunction.isArrayRotation(a, b)).isTrue();
    }

    @Test
    void should_return_false_if_array_rotation_is_not_present() {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 3, 1, 2};

        assertThat(ArrayAwesomeFunction.isArrayRotation(a, b)).isFalse();
    }

}