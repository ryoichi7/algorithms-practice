package com.samoylov.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">...</a>
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefSums = new HashMap<>();
        var sum = 0;
        var result = 0;
        for (var i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == k) {
                result++;
            }
            result += prefSums.getOrDefault(sum - k, 0);
            prefSums.put(sum, prefSums.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
