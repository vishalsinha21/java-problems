package org.vs.ctci.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AnagramTest {

    @Test
    void should_check_if_strings_are_anagrams_of_each_other() {
        Assertions.assertThat(Anagram.isAnagram("abc", "bac")).isTrue();
        Assertions.assertThat(Anagram.isAnagram("abccc", "ccbac")).isTrue();
        Assertions.assertThat(Anagram.isAnagram("abaa", "abba")).isFalse();
        Assertions.assertThat(Anagram.isAnagram("a", "b")).isFalse();
    }

    @Test
    void should_be_able_to_handle_null_values() {
        Assertions.assertThat(Anagram.isAnagram(null, "b")).isFalse();
        Assertions.assertThat(Anagram.isAnagram("a", null)).isFalse();
    }
}