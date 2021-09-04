package org.vs.ctci;

import org.junit.jupiter.api.Test;
import org.vs.ctci.domain.Party;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.vs.ctci.AwesomeFunctions.getCharFrequencyMap;

class AwesomeFunctionsTest {

    @Test
    void should_return_frequency_of_all_characters() {
        assertThat(getCharFrequencyMap("hello".toCharArray()))
                .hasSize(4)
                .containsEntry(Character.valueOf('h'), 1L)
                .containsEntry(Character.valueOf('e'), 1L)
                .containsEntry(Character.valueOf('l'), 2L)
                .containsEntry(Character.valueOf('o'), 1L);

        assertThat(getCharFrequencyMap("h".toCharArray()))
                .hasSize(1)
                .containsEntry(Character.valueOf('h'), 1L);

        assertThat(getCharFrequencyMap("hhhh".toCharArray()))
                .hasSize(1)
                .containsEntry(Character.valueOf('h'), 4L);
    }

    @Test
    void should_return_empty_map() {
        assertThat(getCharFrequencyMap("".toCharArray())).isEmpty();
        assertThat(getCharFrequencyMap(null)).isEmpty();
    }

    @Test
    void should_group_parties_by_order() {
        Party party1 = new Party(BigInteger.valueOf(1000L), BigInteger.valueOf(1L), "AAA");
        Party party2 = new Party(BigInteger.valueOf(1000L), BigInteger.valueOf(2L), "BBB");
        Party party3 = new Party(BigInteger.valueOf(2000L), BigInteger.valueOf(1L), "CCC");
        Party party4 = new Party(BigInteger.valueOf(2000L), BigInteger.valueOf(1L), "DDD");

        Map<BigInteger, java.util.List<Party>> partyMap = AwesomeFunctions.getPartyMap(Arrays.asList(party1, party2, party3, party4));
        assertThat(partyMap).hasSize(2)
                .containsEntry(BigInteger.valueOf(1000L), Arrays.asList(party1, party2))
                .containsEntry(BigInteger.valueOf(2000L), Arrays.asList(party3, party4));
    }
}