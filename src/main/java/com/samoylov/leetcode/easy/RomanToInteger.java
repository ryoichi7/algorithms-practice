package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">task link</a>
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        var result = 0;
        var roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        var integer = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (var i = 0; i < roman.length; ++i) {
            while (s.startsWith(roman[i])) {
                result += integer[i];
                s = s.substring(roman[i].length());
            }
        }
        return result;
    }
}
