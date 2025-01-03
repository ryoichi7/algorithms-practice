package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/maximize-distance-to-closest-person/">task link</a>
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        var left = 0;
        var right = 0;
        var result = 0;
        var cur = 0;
        var hasOne = false;
        for (var i = 0; i < seats.length; ++i) {
            if (seats[i] != 1) {
                cur++;
            } else {
                if (hasOne) {
                    result = Math.max(result, cur / 2);
                } else {
                    result = Math.max(result, cur);
                }
                cur = 1;
                hasOne = true;
            }
        }
        result = Math.max(result, cur - 1);
        return result;
    }
}
