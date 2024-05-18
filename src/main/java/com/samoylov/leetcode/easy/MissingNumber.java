package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/missing-number/description/">task link</a>
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        var map = new int[nums.length + 1];
        for (var num : nums) {
            map[num] = 1;
        }
        for (var i = 0; i <= map.length; ++i) {
            if (map[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
