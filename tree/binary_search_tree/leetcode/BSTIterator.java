package com.company.tree.binary_search_tree.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private List<Integer> list;
    private int index;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.index = 0;
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return this.list.get(index++);
    }

    public boolean hasNext() {
        return this.index < this.list.size();
    }
}
