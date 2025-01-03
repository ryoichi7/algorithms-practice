package com.samoylov.leetcode.medium;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k">task link</a>
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        var remainderToCnt = new HashMap<Integer, Integer>();
        var sum = 0;
        var result = 0;
        remainderToCnt.put(sum, 1);
        for (var num : nums) {
            sum = (sum + ((num % k + k) % k)) % k;
            result += remainderToCnt.getOrDefault(sum, 0);
            remainderToCnt.put(sum, remainderToCnt.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
