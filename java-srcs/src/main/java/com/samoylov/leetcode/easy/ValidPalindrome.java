package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/description/">...</a>
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        var left = 0;
        var right = s.length() - 1;
        var shift = 'a' - 'A';
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            var leftChar = s.charAt(left++);
            var rightChar = s.charAt(right--);

            if (leftChar >= 'A' && leftChar <= 'Z') {
                leftChar += shift;
            }
            if (rightChar >= 'A' && rightChar <= 'Z') {
                rightChar += shift;
            }
            if (leftChar != rightChar) {
                return false;
            }
        }
        return true;
    }
}
