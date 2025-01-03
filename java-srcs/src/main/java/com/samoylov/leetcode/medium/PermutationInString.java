package com.samoylov.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/description/">task link</a>
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> pattern = new HashMap<>();
        for (var ch : s1.toCharArray()) {
            pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int ptr = 0;
        while (ptr < s1.length()) {
            if (pattern.containsKey(s2.charAt(ptr))){
                window.put(s2.charAt(ptr), window.getOrDefault(s2.charAt(ptr), 0) + 1);
            }
            ptr++;
        }
        var curWrongChars = 0;
        for (var key : pattern.keySet()) {
            if (window.getOrDefault(key, 0) - pattern.getOrDefault(key, 0) != 0) {
                curWrongChars++;
            }
        }
        if (curWrongChars == 0) {
            return true;
        }
        while (ptr < s2.length()) {
            var out = s2.charAt(ptr - s1.length());

            if (pattern.containsKey(out)) {
                if (window.get(out) - pattern.getOrDefault(out, 0) == 0) {
                    curWrongChars++;
                } else if (window.get(out) - pattern.getOrDefault(out, 0) == 1) {
                    curWrongChars--;
                }
                window.put(out, window.get(out) - 1);
            }

            var in = s2.charAt(ptr);
            if (pattern.containsKey(in)) {
                if (window.getOrDefault(in, 0) - pattern.getOrDefault(in, 0) == 0) {
                    curWrongChars++;
                } else if (window.getOrDefault(in, 0) - pattern.getOrDefault(in, 0) == -1) {
                    curWrongChars--;
                }
                window.put(s2.charAt(ptr), window.getOrDefault(s2.charAt(ptr), 0) + 1);
            }

            if (curWrongChars == 0) {
                return true;
            }
            ptr++;
        }
        return false;
    }
}
