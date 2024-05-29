package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">task link</a>
 */
public class MaximumDepthOfBinaryTree {
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

    public int maxDepth(TreeNode node) {
        var length = 0;
        if (node == null) {
            return length;
        }
        var left = maxDepth(node.left);
        var right = maxDepth(node.right);
        length += Math.max(left, right);
        return length + 1;
    }
}
