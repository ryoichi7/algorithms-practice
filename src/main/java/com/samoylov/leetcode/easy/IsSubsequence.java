package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/description/">task link</a>
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        var left = 0;
        for (var right = 0; right < t.length(); right++) {
            if (left == s.length()) {
                return true;
            }
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
        }
        if (left == s.length()) {
            return true;
        }
        return false;
    }
}
