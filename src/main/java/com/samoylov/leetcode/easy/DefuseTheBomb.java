package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/defuse-the-bomb/">task link</a>
 */
public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            return new int[code.length];
        }
        var window = 0;
        var result = new int[code.length];
        if (k > 0) {
            for (var i = 1; i <= k; ++i) {
                window += code[i % code.length];
            }
            for (var i = 0; i < code.length; ++i) {
                result[i] = window;
                window -= code[(i + 1) % code.length];
                window += code[(i + 1 + k) % code.length];
            }
        } else {
            for (var i = k; i < 0; ++i) {
                window += code[(code.length + i) % code.length];
            }
            for (var i = 0; i < code.length; ++i) {
                result[i] = window;
                window -= code[(code.length + i + k) % code.length];
                window += code[i % code.length];
            }
        }
        return result;
    }
}
