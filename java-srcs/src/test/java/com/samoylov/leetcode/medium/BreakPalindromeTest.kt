package com.samoylov.leetcode.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BreakPalindromeTest {

    @Test
    fun `leetcode testcase1`() {
        // setup
        val input = "abccba"
        val expected = "aaccba"

        // run
        val actual = BreakPalindrome.breakPalindrome(input)

        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `test single letter should return empty string`() {
        // setup
        val input = "a"
        val expected = ""

        // run
        val actual = BreakPalindrome.breakPalindrome(input)

        // assert
        assertEquals(expected, actual)
    }
}