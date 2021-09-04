package org.vs.hackerrank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilFunctionsTest {

    @Test
    void should_sort_characters_of_string() {
        assertThat(UtilFunctions.sortStringCharacters1("vishal")).isEqualTo("ahilsv");
    }
}