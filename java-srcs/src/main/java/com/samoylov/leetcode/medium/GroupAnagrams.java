package com.samoylov.leetcode.medium;

import java.util.*;
/**
 * <a href="https://leetcode.com/problems/group-anagrams/">...</a>
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (var str : strs) {
            var tmp = str.toCharArray();
            Arrays.sort(tmp);
            var key = String.valueOf(tmp);
            if (groups.containsKey(key)) {
                groups.get(key).add(str);
            } else {
                groups.put(key, new LinkedList<String>(List.of(str)));
            }
        }
        return new ArrayList<>(groups.values());
    }
}
