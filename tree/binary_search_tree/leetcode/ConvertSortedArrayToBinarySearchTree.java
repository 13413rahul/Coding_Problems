package com.company.tree.binary_search_tree.leetcode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class ConvertSortedArrayToBinarySearchTree {
    static class TreeNode {
        TreeNode left, right;
        int val;
    }

    public TreeNode sortedArrayToBST(int[] nums) {


        return macker(nums, 0, nums.length - 1);
    }

    TreeNode macker(int[] nums, int l, int r) {
        if(l > r) {
            return null;
        }

        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[m];
        root.left = macker(nums, l, m - 1);
        root.right = macker(nums, m + 1, r);

        return root;
    }
}
