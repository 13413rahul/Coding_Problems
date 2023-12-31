package com.company.tree.binary_search_tree.leetcode;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
public class TwoSumIVInputIsBST {
    static class TreeNode {
        TreeNode left, right;
        int val;
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode cur, int target) {
        if(cur == null) return false;
        return search(root, cur, target - cur.val) ||
                dfs(root, cur.left, target) ||
                dfs(root, cur.right, target);
    }

    private boolean search(TreeNode root, TreeNode cur, int target) {
        if(root == null) return false;
        return (root.val == target && cur != root)||
                (target > root.val && search(root.right, cur, target)) ||
                (target < root.val && search(root.left, cur, target));
    }

}
