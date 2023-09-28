package com.company.tree.binary_tree.leetcode;

import com.company.tree.binary_tree.gfg.LeftViewOfBST;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/description/
public class RightViewOfBST {
    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
