package com.company.tree.binary_search_tree.leetcode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
public class SearchInBinarySearchTree {
    static class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int val) {
            left = null;
            right = null;
            this.val = val;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {

        // Check if the root node is null or if the root value matches the input value
        if(root == null || root.val == val) {
            // If so, return the root node (which may be null)
            return root;
        }

        // If the input value is less than the root value, search the left subtree recursively
        if(val < root.val) {
            return searchBST(root.left, val);
        }
        // Otherwise, search the right subtree recursively
        else {
            return searchBST(root.right, val);
        }
    }
}
