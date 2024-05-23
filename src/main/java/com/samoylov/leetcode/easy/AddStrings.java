package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/add-strings/description/">task link</a>
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        var result = new StringBuilder();
        var left = num1.length() - 1;
        var right = num2.length() - 1;
        var overflow = 0;
        while(left >= 0 || right >= 0) {
            var cur = overflow;
            if (left >= 0) {
                cur += (num1.charAt(left) - '0');
                left--;
            }
            if (right >= 0) {
                cur += (num2.charAt(right) - '0');
                right--;
            }
            result.append(cur % 10);
            overflow = cur / 10;
        }
        if (overflow > 0) {
            result.append(overflow);
        }
        return result.reverse().toString();
    }
}
