package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/max-consecutive-ones-iii/description/">task link</a>
 */
public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        var curZeroes = 0;
        var left = 0;
        var right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                curZeroes++;
            }
            if (curZeroes > k) {
                if (nums[left] == 0) {
                    curZeroes--;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}
