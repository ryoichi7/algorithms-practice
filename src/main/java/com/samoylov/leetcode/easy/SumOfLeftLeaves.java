package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/sum-of-left-leaves/description">task link</a>
 */
public class SumOfLeftLeaves {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        var sum = 0;
        sum += dfs(node.left, true);
        sum += dfs(node.right, false);
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        }
        return sum;
    }
}
