package com.samoylov.dump.subseq;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.samoylov.dump.subseq.Problem1.findMaxSubstr;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void nullOrLengthZero() {
        String given1 = null;
        String given2 = "";
        assertAll(
                () -> assertThat(findMaxSubstr(given1)).isEqualTo(0),
                () -> assertThat(findMaxSubstr(given2)).isEqualTo(0)
        );
    }

    @Test
    void lengthOne() {
        String given = "a";
        assertThat(findMaxSubstr(given)).isEqualTo(given.length());
    }

    @Test
    void allCharsUnique() {
        String given = "abcd";
        assertThat(findMaxSubstr(given)).isEqualTo(given.length());
    }

    @Test
    void allCharsSame() {
        String given = "aaaa";
        assertThat(findMaxSubstr(given)).isEqualTo(1);
    }

    @Test
    void lastCharRepeats() {
        String given = "abcda";
        assertThat(findMaxSubstr(given)).isEqualTo(4);
    }

    @Test
    void defaultCase() {
        String given = "abcabcabb";
        assertThat(findMaxSubstr(given)).isEqualTo(3);
    }
}