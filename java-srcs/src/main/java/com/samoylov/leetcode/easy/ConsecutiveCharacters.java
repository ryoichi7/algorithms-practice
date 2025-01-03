package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/consecutive-characters/">task link</a>
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        var left = 0;
        var right = 0;
        var result = 0;
        for (; right < s.length(); right++) {
            if (s.charAt(right) != s.charAt(left)) {
                result = Math.max(result, right - left);
                left = right;
            }
        }
        result = Math.max(result, right - left);
        return result;
    }
}
