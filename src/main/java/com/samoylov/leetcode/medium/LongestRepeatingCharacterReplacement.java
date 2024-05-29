package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description">task link</a>
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        var result = 0;
        var max = 0;
        var window = new int[26];
        var left = 0;
        for (var right = 0; right < s.length(); ++right) {
            var ch = s.charAt(right);
            window[ch - 'A']++;
            max = Math.max(max, window[ch - 'A']);
            if (right - left + 1 - max > k) {
                window[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
