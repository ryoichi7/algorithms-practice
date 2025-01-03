package com.samoylov.yandex.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgPrac5Test {

    @Test
    void defaultCase() {
        String s = "abaca";
        String t = "ab";

        var expectedResult = 2;
        var actualResult = AlgPrac5.Solution(s, t);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void FullSeqOfSubsequences() {
        String s = "aaaaa";
        String t = "aa";

        var expectedResult = 4;
        var actualResult = AlgPrac5.Solution(s, t);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void onlyFirstWindowIsResult() {
        String s = "abccc";
        String t = "ba";

        var expectedResult = 1;
        var actualResult = AlgPrac5.Solution(s, t);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void noSubsequenceInSequence() {
        String s = "cdfasd";
        String t = "aa";

        var expectedResult = 0;
        var actualResult = AlgPrac5.Solution(s, t);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}