package com.samoylov.leetcode.medium;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/continuous-subarray-sum/">task link</a>
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        var prefMods = new HashMap<Integer, Integer>();
        var mod = nums[0] % k;
        prefMods.put(mod, 0);
        for (var i = 1; i < nums.length; ++i) {
            mod = (mod + nums[i]) % k;
            if (mod == 0 || (prefMods.containsKey(mod) && i - prefMods.get(mod) > 1)) {
                return true;
            }
            prefMods.putIfAbsent(mod, i);
        }
        return false;
    }
}
