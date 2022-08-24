package org.vs.practice;

import org.junit.jupiter.api.Test;
import org.vs.practice.string.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    public void should_check_if_strings_are_anagram() {
        assertThat(StringUtils.isAnagram("aaab", "baaa")).isTrue();
        assertThat(StringUtils.isAnagram("abccdd", "dbacdc")).isTrue();
        assertThat(StringUtils.isAnagram("abb", "baa")).isFalse();
        assertThat(StringUtils.isAnagram(null, null)).isFalse();
        assertThat(StringUtils.isAnagram("ab", null)).isFalse();
        assertThat(StringUtils.isAnagram(null, "ab")).isFalse();
    }
}