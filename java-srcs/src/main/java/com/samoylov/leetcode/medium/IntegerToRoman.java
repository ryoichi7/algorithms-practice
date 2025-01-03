package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">task link</a>
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        var result = new StringBuilder();
        var roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        var integer = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (var i = 0; i < roman.length; ++i) {
            while (num >= integer[i]) {
                result.append(roman[i]);
                num -= integer[i];
            }
        }
        return result.toString();
    }
}
