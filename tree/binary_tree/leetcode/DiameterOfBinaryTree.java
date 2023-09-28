package com.company.tree.binary_tree.leetcode;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
