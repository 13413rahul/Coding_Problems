package com.company.tree.binary_tree.leetcode;

// https://leetcode.com/problems/balanced-binary-tree/description/
public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }

    int dfsHeight (TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
