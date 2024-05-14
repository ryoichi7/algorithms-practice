package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">task link</a>
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (hasDescendant(p, q)) {
            return p;
        }
        if (hasDescendant(q, p)) {
            return q;
        }
        return dfs(root, p, q);
    }

    public boolean hasDescendant(TreeNode curNode, TreeNode target) {
        if (curNode == null) {
            return false;
        }
        if (curNode.val == target.val) {
            return true;
        }
        return hasDescendant(curNode.left, target) || hasDescendant(curNode.right, target);
    }

    public TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return null;
        }
        var left = dfs(cur.left, p, q);
        if (left != null) {
            return left;
        }
        var right = dfs(cur.right, p, q);
        if (right != null) {
            return right;
        }
        if (hasDescendant(cur, p) && hasDescendant(cur, q)) {
            return cur;
        }
        return null;
    }
}
