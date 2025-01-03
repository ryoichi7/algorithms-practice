package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/single-number/description">task link</a>
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        var xor = 0;
        for (var num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
