package com.samoylov.leetcode.hard;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">task link</a>
 */
public class BinaryTreeMaximumPathSum {
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
    public int maxPathSum(TreeNode root) {
        var result = new int[]{root.val};
        dfs(root, result);
        return result[0];
    }

    public int dfs(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        var left = Math.max(dfs(node.left, result), 0);
        var right = Math.max(dfs(node.right, result), 0);

        result[0] = Math.max(result[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
