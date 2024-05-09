package com.samoylov.leetcode.medium;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">task link</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        var window = new HashMap<Character, Integer>();
        var left = 0;
        var result = 0;
        for (var right = 0; right < s.length(); right++) {
            var current = s.charAt(right);
            if (window.containsKey(current)) {
                left = Math.max(window.get(current) + 1, left);
            }
            window.put(current, right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
