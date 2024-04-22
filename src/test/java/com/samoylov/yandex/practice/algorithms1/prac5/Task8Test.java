package com.samoylov.yandex.practice.algorithms1.prac5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    void findMaxSubsequenceCase1() {
        var seq = "abb";
        var k = 1;

        var expected = new int[]{2, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void findMaxSubsequenceCase2() {
        var seq = "ababa";
        var k = 2;

        var expected = new int[]{4, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void length1() {
        var seq = "a";
        var k = 2;

        var expected = new int[]{1, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void answerIsLastSeq() {
        var seq = "abbbaa";
        var k = 2;

        var expected = new int[]{4, 3};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void answerIsFullString() {
        var seq = "abcdef";
        var k = 2;

        var expected = new int[]{6, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void answerIsFirst() {
        var seq = "ababbb";
        var k = 2;

        var expected = new int[]{4, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void allCharactersExceedK() {
        var seq = "aaaaaa";
        var k = 2;

        var expected = new int[]{2, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void kEqualsOne() {
        var seq = "abcabc";
        var k = 1;

        var expected = new int[]{3, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void allCharactersSame() {
        var seq = "aaaa";
        var k = 2;

        var expected = new int[]{2, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    void kEqualsN() {
        var seq = "abcdef";
        var k = 6;

        var expected = new int[]{6, 1};
        var actual = Task8.findMaxSubsequence(seq, k);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }
}