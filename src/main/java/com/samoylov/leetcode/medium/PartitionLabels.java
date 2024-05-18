package com.samoylov.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/partition-labels/">task link</a>
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        var latestIndexes = new HashMap<Character, Integer>();

        for (var i = 0; i < s.length(); ++i) {
            latestIndexes.put(s.charAt(i), i);
        }

        var result = new ArrayList<Integer>();
        var max = 0;
        var prev = -1;
        for (var i = 0; i < s.length(); ++i) {
            max = Math.max(max, latestIndexes.get(s.charAt(i)));
            if (max == i) {
                result.add(max - prev);
                prev = max;
            }
        }
        return result;
    }
}
