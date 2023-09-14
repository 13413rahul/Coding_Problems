package com.company.dfs.leetcode;

// https://leetcode.com/problems/path-sum/description/
public class RootToLeafSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        Solution solution = new Solution();
        boolean isSumFromRootToLeafIsTargetSum = solution.hasPathSum(root, targetSum);
        System.out.println(isSumFromRootToLeafIsTargetSum);
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) {
                return false;
            }

            if(root.left == null && root.right == null && targetSum == root.val) {
                return true;
            }

            boolean isLeftLeafTargetSum = hasPathSum(root.left, targetSum - root.val);
            boolean isRightLeafTargetSum = hasPathSum(root.right, targetSum - root.val);

            return isLeftLeafTargetSum || isRightLeafTargetSum;
        }
    }
}
