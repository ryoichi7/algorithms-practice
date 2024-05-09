package com.samoylov.leetcode.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">task link</a>
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] != i2[0]) {
                return i1[0] - i2[0];
            }
            return i1[1] - i2[1];
        });
        List<int[]> merge = new ArrayList<>();
        var left = 0;
        var right = 1;
        merge.add(intervals[left]);
        while (right < intervals.length) {
            var leftInterval = merge.get(left);
            var rightInterval = intervals[right];
            if (rightInterval[0] >= leftInterval[0] && rightInterval[0] <= leftInterval[1]) {
                leftInterval[1] = Math.max(rightInterval[1], leftInterval[1]);
            } else {
                merge.add(rightInterval);
                left++;
            }
            right++;
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
