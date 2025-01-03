package com.samoylov.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">task link</a>
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        var result = new HashSet<List<Integer>>();
        for (var first = 0; first < numbers.length - 1; first++) {
            var left = first + 1;
            var right = numbers.length - 1;
            while (left < right) {
                var sum = numbers[first] + numbers[left] + numbers[right];
                if (sum == 0) {
                    result.add(List.of(numbers[first], numbers[left], numbers[right]));
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
