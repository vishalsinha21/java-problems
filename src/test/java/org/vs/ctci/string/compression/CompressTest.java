package org.vs.ctci.string.compression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompressTest {

    @Test
    void should_return_compressed_string() {
        assertThat(Compress.getCompressedString("aabcccccaaa")).isEqualTo("a2b1c5a3");
        assertThat(Compress.getCompressedString("abcd")).isEqualTo("abcd");
        assertThat(Compress.getCompressedString("aabcdd")).isEqualTo("a2b1c1d2");
        assertThat(Compress.getCompressedString("aaaa")).isEqualTo("a4");
        assertThat(Compress.getCompressedString("a")).isEqualTo("a");
    }
}