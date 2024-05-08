package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/description/">...</a>
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        var left = 0;
        var right = 0;
        while (left < nums.length) {
            if (nums[left] != 0) {
                left++;
                right++;
            } else {
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right == nums.length) {
                    right--;
                }
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
        }
    }
}
