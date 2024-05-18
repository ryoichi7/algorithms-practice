package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/">task link</a>
 */
public class LongestSubarrayAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        var maxLength = 0;
        var curZeros = 0;
        var totalZeros = 0;
        var left = 0;
        var right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                totalZeros++;
                curZeros++;
            }
            if (curZeros > 1) {
                maxLength = Math.max(maxLength, right - left);
                while (curZeros > 1) {
                    if (nums[left] == 0) {
                        curZeros--;
                    }
                    left++;
                }
            }
            right++;
        }
        if (totalZeros <= 1) {
            maxLength = right - left;
        } else {
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength - 1;
    }
}
