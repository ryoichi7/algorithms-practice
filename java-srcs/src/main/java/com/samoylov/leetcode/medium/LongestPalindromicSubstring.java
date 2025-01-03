package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/description/">task link</a>
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        var start = 0;
        var end = 0;

        for (int i = 0; i < s.length(); ++i) {
            var curLen = Math.max(findPalindrome(s, i, i), findPalindrome(s, i, i + 1));
            if (curLen > end - start + 1) {
                start = i - (curLen - 1) / 2;
                end = i + curLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}