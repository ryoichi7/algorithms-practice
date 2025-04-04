package com.samoylov.leetcode.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfBlackBlocksTest {
    @Test
    fun `leetcode testcase1`() {
        // setup
        val (m, n) = listOf(3,3)
        val coordinates = arrayOf(intArrayOf(0, 0))
        val expected = longArrayOf(3, 1, 0, 0, 0)

        // run
        val actual = NumberOfBlackBlocks.countBlackBlocks(m, n, coordinates)

        // assert
        expected.forEachIndexed { index, value ->
            assertEquals(actual[index], value)
        }
    }

    @Test
    fun `leetcode testcase2`() {
        // setup
        val (m, n) = listOf(3,3)
        val coordinates = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 2)
        )
        val expected = longArrayOf(0, 2, 2, 0, 0)

        // run
        val actual = NumberOfBlackBlocks.countBlackBlocks(m, n, coordinates)

        // assert
        expected.forEachIndexed { index, value ->
            assertEquals(actual[index], value)
        }
    }
}