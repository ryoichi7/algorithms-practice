package com.samoylov.leetcode.easy;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/jewels-and-stones/description/">task link</a>
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        var jewelsMap = new HashSet<Character>();
        var result = 0;
        for (var ch : jewels.toCharArray()) {
            jewelsMap.add(ch);
        }
        for (var ch : stones.toCharArray()) {
            if (jewelsMap.contains(ch)) {
                result++;
            }
        }
        return result;
    }
}
