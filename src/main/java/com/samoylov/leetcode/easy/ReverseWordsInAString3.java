package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">task link</a>
 */
public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        var string = s.toCharArray();
        var left = 0;
        for (var right = 0; right < string.length; ++right) {
            if (string[right] == ' ') {
                reverse(string, left, right - 1);
                left = right + 1;
            }
        }
        reverse(string, left, string.length - 1);
        return String.valueOf(string);
    }

    public void reverse(char[] string, int left, int right) {
        while (left < right) {
            var prevLeft = string[left];
            string[left] = string[right];
            string[right] = prevLeft;
            left++;
            right--;
        }
    }
}
