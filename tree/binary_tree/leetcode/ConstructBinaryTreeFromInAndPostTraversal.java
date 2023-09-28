package com.company.tree.binary_tree.leetcode;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class ConstructBinaryTreeFromInAndPostTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length, postorder, 0, postorder.length - 1);
    }

    TreeNode dfs(int[] in, int ii, int ij, int[] post, int pi, int pj) {
        if(ii > ij || pi > pj) {
            return null;
        }

        TreeNode node = new TreeNode(post[pj]);
        int ind = -1;
        for(int i = ii; i < in.length; i++) {
            if(post[pj] == in[i]) {
                ind = i;
                break;
            }
        }


        node.left = dfs(in, ii, ind - 1, post, pi, pi + ind - ii - 1);
        node.right = dfs(in, ind + 1, ij, post, pi + ind - ii,  pj - 1);

        return node;
    }
}
