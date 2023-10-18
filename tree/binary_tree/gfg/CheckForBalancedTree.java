package com.company.tree.binary_tree.gfg;

// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
public class CheckForBalancedTree {
    class Node {
        int data;
        Node left, right;
    }

    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        // Your code here
        return h(root)!=-1;
    }

    int h(Node r)
    {
        if(r==null) {
            return 0;
        }

        int l=h(r.left);
        if(l==-1) {
            return -1;
        }

        int ri = h(r.right);
        if(ri==-1) {
            return -1;
        }

        if(Math.abs(l-ri)>1) {
            return -1;
        }

        return Math.max(l,ri)+1;
    }
}
