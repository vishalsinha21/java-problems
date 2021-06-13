package org.vs.ctci.string.oneeditaway;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OneAwayTest {

    @Test
    void should_test_if_one_edit_away() {
        assertThat(OneAway.isOneAway("pale", "pales")).isTrue();
        assertThat(OneAway.isOneAway("pale", "bale")).isTrue();
        assertThat(OneAway.isOneAway("pale", "bake")).isFalse();
        assertThat(OneAway.isOneAway("ppp", "pppd")).isTrue();
        assertThat(OneAway.isOneAway("ppp", "pppp")).isTrue();
        assertThat(OneAway.isOneAway("ppp", "ppppp")).isFalse();
    }
}