package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome-ii">task link</a>
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
