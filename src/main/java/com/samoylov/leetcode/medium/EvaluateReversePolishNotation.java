package com.samoylov.leetcode.medium;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">task link</a>
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        for (var token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                var right = stack.pop();
                var left = stack.pop();
                switch (token) {
                    case "+" -> stack.push(left + right);
                    case "-" -> stack.push(left - right);
                    case "/" -> stack.push(left / right);
                    case "*" -> stack.push(left * right);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
