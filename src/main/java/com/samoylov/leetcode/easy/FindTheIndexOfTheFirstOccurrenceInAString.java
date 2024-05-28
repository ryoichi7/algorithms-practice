package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">task link</a>
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        var hayLength = haystack.length();
        var needleLength = needle.length();
        if (hayLength < needleLength) {
            return -1;
        }
        for (var left = 0; left <= hayLength - needleLength; left++) {
            var right = 0;
            while (right < needleLength && haystack.charAt(left + right) == needle.charAt(right)) {
                right++;
            }
            if (right == needleLength) {
                return left;
            }
        }
        return -1;
    }
}
