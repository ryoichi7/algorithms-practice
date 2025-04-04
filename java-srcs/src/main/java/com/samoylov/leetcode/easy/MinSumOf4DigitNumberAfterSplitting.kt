package com.samoylov.leetcode.easy

/**
 * <a href="https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/">task link</a>
 */
object MinSumOf4DigitNumberAfterSplitting {
    fun minimumSum(num: Int): Int {
        val arr = IntArray(4)
        var number = num
        var i = 0
        while (number > 0) {
            arr[i++] = number % 10
            number /= 10
        }
        arr.sort()
        return (arr[0] * 10 + arr[3]) + (arr[1] * 10 + arr[2])
    }
}