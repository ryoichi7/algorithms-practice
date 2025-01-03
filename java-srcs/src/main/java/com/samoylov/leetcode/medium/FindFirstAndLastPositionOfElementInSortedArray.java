package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">task link</a>
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        var left = binarySearch(nums, target, true);
        var right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target, boolean isLeftCorner) {
        var left = 0;
        var right = nums.length - 1;
        var result = -1;
        while (left <= right) {
            var mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                result = mid;
                if (isLeftCorner) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }
}
