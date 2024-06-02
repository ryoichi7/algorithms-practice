package com.samoylov.leetcode.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-strong-pair-xor-i/description/">task link</a>
 */
public class MaximumStrongPairXOR {
    public int maximumStrongPairXor(int[] nums) {
        var result = 0;
        Arrays.sort(nums);
        for (var left = 0; left < nums.length; ++left) {
            var right = left;
            while (right < nums.length && Math.abs(nums[left] - nums[right]) <= Math.min(nums[left], nums[right])) {
                result = Math.max(result, nums[left] ^ nums[right]);
                right++;
            }
        }
        return result;
    }
}
