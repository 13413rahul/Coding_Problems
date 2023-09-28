package com.company.tree.binary_tree.leetcode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestorOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
}
