package com.samoylov.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays">task link</a>
 */
public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var result = new ArrayList<List<Integer>>();
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        var intersection = new HashSet<Integer>();
        for (var num : nums1) {
            set1.add(num);
        }
        for (var num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
            set2.add(num);
        }
        set1.removeAll(intersection);
        set2.removeAll(intersection);

        result.add(new ArrayList<Integer>(set1));
        result.add(new ArrayList<Integer>(set2));

        return result;
    }
}
