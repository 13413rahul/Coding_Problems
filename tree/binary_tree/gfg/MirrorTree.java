package com.company.tree.binary_tree.gfg;

import com.company.tree.binary_tree.leetcode.FlattenBinaryTreeToLinkedList;

// https://practice.geeksforgeeks.org/problems/mirror-tree/1
public class MirrorTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
        }
    }

    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) return;
        Node temp;

        // calling mirror function recursively for left and right subtrees.
        mirror(node.left);
        mirror(node.right);

        // swapping the left and right subtree.
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
