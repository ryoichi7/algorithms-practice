package com.samoylov.leetcode.easy;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings/description">task link</a>
 */
public class IsomorphicStrings {
    public boolean isIsomorphicV2(String s, String t) {
        var charToTemplate1 = new HashMap<Character, Integer>();
        var charToTemplate2 = new HashMap<Character, Integer>();
        var template = 0;
        for (var i = 0; i < s.length(); ++i) {
            var ch1 = s.charAt(i);
            var ch2 = t.charAt(i);
            if (charToTemplate1.getOrDefault(ch1, -1) == charToTemplate2.getOrDefault(ch2, -1)) {
                if (!charToTemplate1.containsKey(ch1)) {
                    template++;
                }
                charToTemplate1.putIfAbsent(ch1, template);
                charToTemplate2.putIfAbsent(ch2, template);
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        var template = new int[s.length()];
        var dict = new HashMap<Character, Integer>();
        var generic = 0;
        dict.put(s.charAt(0), 0);
        for (var i = 1; i < s.length(); ++i) {
            if (!dict.containsKey(s.charAt(i))) {
                generic++;
                dict.put(s.charAt(i), generic);
            }
            template[i] = dict.getOrDefault(s.charAt(i), generic);
        }
        generic = 0;
        dict.clear();
        dict.put(t.charAt(0), 0);
        for (var i = 1; i < t.length(); ++i) {
            if (!dict.containsKey(t.charAt(i))) {
                generic++;
                dict.put(t.charAt(i), generic);
            }
            if (template[i] != dict.getOrDefault(t.charAt(i), generic)) {
                return false;
            }
        }
        return true;
    }
}
