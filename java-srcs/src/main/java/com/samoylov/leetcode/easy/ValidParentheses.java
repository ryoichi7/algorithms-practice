package com.samoylov.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/description/">task link</a>
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> order = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            var ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                order.add(ch);
            } else {
                if (order.isEmpty()) {
                    return false;
                }
                var open = order.remove(order.size() - 1);
                if (open == '(' && ch != ')' || open == '[' && ch != ']' || open == '{' && ch != '}') {
                    return false;
                }
            }
        }
        return order.isEmpty();
    }
}
