package com.samoylov.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-k-closest-elements">task link</a>
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var result = new ArrayList<Integer>(k);

        var left = 0;
        var right = arr.length - 1;
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        while (left <= right) {
            result.add(arr[left++]);
        }
        return result;
    }
}
