package com.samoylov.leetcode.easy;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/description/">task link</a>
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        var charOccurrences = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); ++i) {
            var ch = s.charAt(i);
            charOccurrences.put(ch, charOccurrences.getOrDefault(ch, 0) + 1);
        }
        for (var i = 0; i < s.length(); ++i) {
            var ch = s.charAt(i);
            if (charOccurrences.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
