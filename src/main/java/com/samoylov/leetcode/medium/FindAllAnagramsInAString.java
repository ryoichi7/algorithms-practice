package com.samoylov.leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">task link</a>
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String string, String p) {
        if (string.length() < p.length()) {
            return Collections.emptyList();
        }
        var result = new LinkedList<Integer>();
        var pattern = new HashMap<Character, Integer>();
        for (var ch : p.toCharArray()) {
            pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
        }
        var window = new HashMap<Character, Integer>();
        var ptr = 0;
        while (ptr < p.length()) {
            var ch = string.charAt(ptr);
            if (pattern.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
            }
            ptr++;
        }
        var wrongChars = 0;
        for (var key : pattern.keySet()) {
            if (pattern.get(key) - window.getOrDefault(key, 0) != 0) {
                wrongChars++;
            }
        }
        if (wrongChars == 0) {
            result.add(ptr - p.length());
        }
        while (ptr < string.length()) {
            var out = string.charAt(ptr - p.length());
            if (pattern.containsKey(out)) {
                if (window.get(out) - pattern.get(out) == 0) {
                    wrongChars++;
                } else if (window.get(out) - pattern.get(out) == 1) {
                    wrongChars--;
                }
                window.put(out, window.get(out) - 1);
            }
            var in = string.charAt(ptr);
            if (pattern.containsKey(in)) {
                if (window.getOrDefault(in, 0) - pattern.get(in) == 0) {
                    wrongChars++;
                } else if (window.getOrDefault(in, 0) - pattern.get(in) == -1) {
                    wrongChars--;
                }
                window.put(in, window.getOrDefault(in, 0) + 1);
            }
            ptr++;
            if (wrongChars == 0) {
                result.add(ptr - p.length());
            }
        }
        return result;
    }
}
