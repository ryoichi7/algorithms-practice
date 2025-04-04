package com.samoylov.leetcode.medium

/**
 * <a href="https://leetcode.com/problems/break-a-palindrome/">task link</a>
 */
object BreakPalindrome {
    fun breakPalindrome(palindrome: String): String {
        val length = palindrome.length
        if (length == 1) {
            return ""
        }
        val brokenPalindrome = palindrome.toCharArray()
        var left = 0
        while (left < length / 2) {
            if (brokenPalindrome[left] != 'a') {
                brokenPalindrome[left] = 'a'
                return brokenPalindrome.concatToString()
            }
            left++
        }
        brokenPalindrome[length - 1]++
        return brokenPalindrome.concatToString()
    }
}