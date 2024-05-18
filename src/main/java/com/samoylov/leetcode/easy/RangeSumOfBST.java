package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/range-sum-of-bst/description/">task link</a>
 */
public class RangeSumOfBST {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        return rangeSum(root, low, high);
    }

    public int rangeSum(TreeNode node, int low, int high) {
        var result = 0;
        if (node.val <= high && node.val >= low) {
            result += node.val;
        }
        if (node.left != null) {
            result += rangeSum(node.left, low, high);
        }
        if (node.right != null) {
            result += rangeSum(node.right, low, high);
        }
        return result;
    }
}
