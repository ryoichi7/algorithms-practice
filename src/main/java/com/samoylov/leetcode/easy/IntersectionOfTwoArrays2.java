package com.samoylov.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">task link</a>
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        var firstMap = new HashMap<Integer, Integer>();
        var result = new LinkedList<Integer>();
        for (var num : nums1) {
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);
        }

        for (var num : nums2) {
            if (firstMap.getOrDefault(num, 0) > 0) {
                result.add(num);
                firstMap.put(num, firstMap.getOrDefault(num, 0) - 1);
            }
        }
        var answer = new int[result.size()];
        var i = 0;
        for (var num : result) {
            answer[i++] = num;
        }
        return answer;
    }
}
