package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/">task link</a>
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        var result = new int[nums.length];
        var left = 0;
        var right = nums.length - 1;

        for (var i = nums.length - 1; i >= 0; --i) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
