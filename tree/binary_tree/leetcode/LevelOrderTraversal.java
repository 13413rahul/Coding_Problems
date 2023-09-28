package com.company.tree.binary_tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public List<Integer> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> wrapList = new ArrayList<Integer>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){

            if(queue.peek().left != null)
                queue.offer(queue.peek().left);

            if(queue.peek().right != null)
                queue.offer(queue.peek().right);

            wrapList.add(queue.poll().val);
        }
        return wrapList;
    }
}
