package com.samoylov.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/summary-ranges/">...</a>
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        var left = 0;
        var right = 1;
        while (right < nums.length) {
            if (Math.abs(nums[right] - nums[right - 1]) > 1) {
                if (nums[right - 1] == nums[left]) {
                    result.add(String.valueOf(nums[right - 1]));
                } else {
                    result.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
            right++;
        }
        if (nums[right - 1] == nums[left]) {
            result.add(String.valueOf(nums[right - 1]));
        } else {
            result.add(nums[left] + "->" + nums[right - 1]);
        }
        return result;
    }
}
