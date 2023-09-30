package com.company.tree.binary_search_tree.leetcode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class LowestCommonAncestorOfBinarySearchTree {
    static class TreeNode {
        TreeNode left, right;
        int val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null) {
            return null;
        }

        if(root == a || root == b) {
            return root;
        }

        TreeNode l = lca(root.left, a, b);

        TreeNode r = lca(root.right, a, b);

        if(l != null && r != null) {
            return root;
        }

        return l != null ? l : r;
    }
}
