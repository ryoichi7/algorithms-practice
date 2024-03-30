package com.samoylov.yandex.practice.algorithms5.prac3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void shouldBeZeroIf1Element() {
        var actual = Task3.getResult(List.of(1), 1);
        var expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void twoUniqueNumbers() {
        var actual = Task3.getResult(List.of(1, 1, 1, 2, 2, 2), 6);
        var expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void case1() {
        var actual = Task3.getResult(List.of(1, 2, 3, 4, 5), 5);
        var expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void case2() {
        var actual = Task3.getResult(List.of(1, 1, 2, 3, 5, 5, 2, 2, 1, 5), 10);
        var expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void gpt4SuggestionCase1() {
        var actual = Task3.getResult(List.of(1, 1, 1, 10, 10, 10, 20, 20, 20), 9);
        var expected = 6;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void gpt4SuggestionCase2() {
        var actual = Task3.getResult(List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), 10);
        var expected = 6;
        Assertions.assertEquals(expected, actual);
    }
}