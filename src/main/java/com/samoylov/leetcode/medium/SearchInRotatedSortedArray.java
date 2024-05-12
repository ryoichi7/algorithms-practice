package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">task link</a>
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        var result = -1;
        var left = 0;
        var right = nums.length - 1;
        var mid = findCorner(nums, left, right);
        if (mid == -1) {
            return binarySearch(nums, left, right, target);
        }
        return Math.max(binarySearch(nums, left, mid - 1, target), binarySearch(nums, mid, right, target));
    }

    //TODO: fix corner case bugs when the amount of elements is 3 or less
    public int findCorner(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if ((mid > 0 && nums[mid] < nums[mid - 1]) || (mid < nums.length - 1 && nums[mid] > nums[mid + 1])) {
            return mid;
        }
        int leftSearch = findCorner(nums, left, mid - 1);
        if (leftSearch != -1) {
            return leftSearch;
        }
        return findCorner(nums, mid + 1, right);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            var mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
