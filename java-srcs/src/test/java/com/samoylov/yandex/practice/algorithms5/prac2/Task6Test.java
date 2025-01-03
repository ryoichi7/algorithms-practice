package com.samoylov.yandex.practice.algorithms5.prac2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.samoylov.yandex.practice.algorithms5.prac2.Task6.getMaxJackpot;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void case1() {
        var expected = 5;
        var actual = getMaxJackpot(new int[]{3, 5, 2}, List.of(1, 2, 3, 4, 5), 5);
        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        var expected = 4;
        var actual = getMaxJackpot(new int[]{15, 15, 2}, List.of(1, 2, 3, 4, 5), 5);
        assertEquals(expected, actual);
    }

    @Test
    void case3() {
        var expected = 5;
        var actual = getMaxJackpot(new int[]{2, 5, 2}, List.of(5, 4, 3, 2, 1), 5);
        assertEquals(expected, actual);
    }
}