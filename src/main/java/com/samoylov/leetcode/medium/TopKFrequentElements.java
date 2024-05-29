package com.samoylov.leetcode.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/description">task link</a>
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var elemToFreq = new HashMap<Integer, Integer>();
        List<Integer>[] FreqToElems = new List[nums.length + 1];
        for (var num : nums){
            elemToFreq.put(num, elemToFreq.getOrDefault(num, 0) + 1);
        }
        for (var entry : elemToFreq.entrySet()) {
            if (FreqToElems[entry.getValue()] == null) {
                FreqToElems[entry.getValue()] = new LinkedList<Integer>();
            }
            FreqToElems[entry.getValue()].add(entry.getKey());
        }
        var result = new int[k];
        var ptr = 0;
        for (var i = FreqToElems.length - 1; i >= 0; --i){
            if (FreqToElems[i] != null) {
                for (var el : FreqToElems[i]) {
                    result[ptr++] = el;
                }
            }
            if (ptr == k) {
                break;
            }
        }
        return result;
    }
}
