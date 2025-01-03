package com.samoylov.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/description/">...</a>
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result, 0, 0, "", n);
        return result;
    }

    public void dfs(List<String> result, int left, int right, String str, int n) {
        if (str.length() == n * 2) {
            result.add(str);
            return;
        }
        if (left < n) {
            dfs(result, left + 1, right, str + "(", n);
        }
        if (right < left) {
            dfs(result, left, right + 1, str + ")", n);
        }
    }
}
