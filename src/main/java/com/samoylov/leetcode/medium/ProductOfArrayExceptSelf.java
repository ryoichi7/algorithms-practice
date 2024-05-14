package com.samoylov.leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">task link</a>
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        Arrays.fill(result, 1); // init with 1's

        for (var i = 0; i < nums.length - 1; ++i) { // fill result with prefix products
            result[i + 1] *= result[i] * nums[i];
        }

        var suff = 1; // dynamic suffix value for each element from end to start

        for (var i = nums.length - 1; i >= 0; --i) { // update result with suffix products
            result[i] *= suff;
            suff *= nums[i];
        }

        return result;
    }
}
