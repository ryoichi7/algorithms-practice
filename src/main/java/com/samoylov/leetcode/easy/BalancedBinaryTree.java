package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree">task link</a>
 */
public class BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        if (Math.abs(right - left) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        var left = dfs(node.left);
        var right = dfs(node.right);
        return Math.max(left, right) + 1;
    }
}
