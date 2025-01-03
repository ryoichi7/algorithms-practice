package com.samoylov.leetcode.easy;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">task link</a>
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var result = new int[] {0, 1};
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
