package com.samoylov.leetcode.medium;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        var occurrences = new int[2 * 10000 + 1];
        for (var num : nums){
            occurrences[num + 10000] += 1;
        }
        var numsLeft = k;
        for (int i = occurrences.length - 1; i > 0; --i){
            if (occurrences[i] > 0){
                numsLeft -= occurrences[i];
            }
            if (numsLeft <= 0){
                return i - 10000;
            }
        }
        return 0;
    }
}
