package com.company.tree.binary_tree.gfg;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBST {
    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public List<Integer> lightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        leftView(root, result, 0);
        return result;
    }

    public void leftView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);


    }
}
