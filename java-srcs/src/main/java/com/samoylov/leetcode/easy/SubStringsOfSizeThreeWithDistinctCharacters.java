package com.samoylov.leetcode.easy;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/">task link</a>
 */
public class SubStringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        var result = 0;
        var window = new HashMap<Character, Integer>();
        for (var i = 0; i < 3; ++i) {
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (window.size() == 3) {
            result++;
        }
        for (var i = 3; i < s.length(); ++i) {
            var elemOut = s.charAt(i - 3);
            if (window.get(elemOut) == 1) {
                window.remove(elemOut);
            } else {
                window.put(elemOut, window.get(elemOut) - 1);
            }
            var elemIn = s.charAt(i);
            window.put(elemIn, window.getOrDefault(elemIn, 0) + 1);
            if (window.size() == 3) {
                result++;
            }
        }
        return result;
    }
}
