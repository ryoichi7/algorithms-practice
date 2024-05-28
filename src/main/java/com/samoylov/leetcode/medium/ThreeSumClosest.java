package com.samoylov.leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">task link</a>
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        var closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (var first = 0; first < nums.length - 1; first++) {
            var left = first + 1;
            var right = nums.length - 1;
            while (left < right) {
                var sum = nums[first] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closestSum;
    }
}
