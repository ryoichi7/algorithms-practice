package com.samoylov.leetcode.hard;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingWaterTest {

    private static TrappingWater TRAPPING_WATER;
    @BeforeAll
    static void init(){
        TRAPPING_WATER = new TrappingWater();
    }
    @Test
    void case1() {
        var given = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        var expected = 6;
        var actual = TRAPPING_WATER.trap(given);
        assertEquals(expected, actual);
    }

    @Test
    void case2() {
        var given = new int[]{4,2,0,3,2,5};
        var expected = 9;
        var actual = TRAPPING_WATER.trap(given);
        assertEquals(expected, actual);
    }
}