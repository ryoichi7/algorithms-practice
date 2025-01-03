package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">task link</a>
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        var shift = 0;
        for (var i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                shift++;
            } else {
                nums[i - shift] = nums[i];
            }
        }
        return nums.length - shift;
    }
}
