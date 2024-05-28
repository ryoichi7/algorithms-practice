package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/maximum-subarray/description">task link</a>
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        var result = Integer.MIN_VALUE;
        var curSum = 0;
        for (var num : nums) {
            curSum += num;
            result = Math.max(result, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return result;
    }
}
