package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description">task link</a>
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        var end = -2;
        var max = Integer.MIN_VALUE;
        for (var i = 0; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                end = i;
            }
        }
        var start = -1;
        var min = Integer.MAX_VALUE;
        for (var i = nums.length - 1; i >= 0; --i) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                start = i;
            }
        }
        return end - start + 1;
    }
}
