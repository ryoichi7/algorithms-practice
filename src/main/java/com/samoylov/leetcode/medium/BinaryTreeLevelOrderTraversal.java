package com.samoylov.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/description/">task link</a>
 */
public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        bfs(root, result, 0);
        return result;
    }

    public void bfs(TreeNode node, List<List<Integer>> result, int lvl) {
        if (node == null) {
            return;
        }
        if (result.size() == lvl) {
            var list = new ArrayList<Integer>();
            list.add(node.val);
            result.add(list);
        } else {
            result.get(lvl).add(node.val);
        }
        bfs(node.left, result, lvl + 1);
        bfs(node.right, result, lvl + 1);
    }
}
