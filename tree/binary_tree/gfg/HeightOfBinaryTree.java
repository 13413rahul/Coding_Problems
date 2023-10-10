package com.company.tree.binary_tree.gfg;

// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
public class HeightOfBinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    int height(Node node)
    {
        if(node==null) {
            return 0;
        }

        return Math.max(height(node.left),height(node.right)) + 1;
    }
}
