package com.company.dynamic_programing.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/unique-binary-search-trees-ii/description/
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        List<Solution.TreeNode> trees = solution.generateTrees(n);
        for(Solution.TreeNode root : trees) {
            solution.dfs(root);
            System.out.println();
        }
    }

    static class Solution {

        class Pair<K, V> {
            K key;
            V value;
            Pair(K k, V v) {
                this.key = k;
                this.value = v;
            }
        }

        public class TreeNode {
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

        public void dfs(TreeNode root) {
            if(root == null) {
                System.out.print(" NULL ");
                return;
            }

            System.out.print(root.val + " ");
            dfs(root.left);
            dfs(root.right);
        }

        public List<TreeNode> allPossibleBST(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> memo) {
            List<TreeNode> res = new ArrayList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            if (memo.containsKey(new Pair<>(start, end))) {
                return memo.get(new Pair<>(start, end));
            }
            // Iterate through all values from start to end to construct left and right subtree recursively.
            for (int i = start; i <= end; ++i) {
                List<TreeNode> leftSubTrees = allPossibleBST(start, i - 1, memo);
                List<TreeNode> rightSubTrees = allPossibleBST(i + 1, end, memo);

                // Loop through all left and right subtrees and connect them to ith root.
                for (TreeNode left: leftSubTrees) {
                    for (TreeNode right: rightSubTrees) {
                        TreeNode root = new TreeNode(i, left, right);
                        res.add(root);
                    }
                }
            }
            memo.put(new Pair<>(start, end), res);
            return res;
        }

        public List<TreeNode> generateTrees(int n) {
            Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
            return allPossibleBST(1, n, memo);
        }
    }
}
