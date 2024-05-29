package com.samoylov.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">task link</a>
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        zigzag(root, result, 0);
        return result;
    }

    public void zigzag(TreeNode node, List<List<Integer>> result, int lvl) {
        if (node == null) {
            return;
        }
        if (result.size() == lvl) {
            var curList = new LinkedList<Integer>();
            result.add(curList);
        }
        if (lvl % 2 == 0) {
            result.get(lvl).add(node.val);
        } else {
            result.get(lvl).addFirst(node.val);;
        }
        zigzag(node.left, result, lvl + 1);
        zigzag(node.right, result, lvl + 1);
    }
}
