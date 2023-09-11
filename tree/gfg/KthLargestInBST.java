package com.company.tree.gfg;

// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
public class KthLargestInBST {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        int k = 3;

        Solution solution = new Solution();
        int kthLargestEle = solution.kthLargest(root, k);
        System.out.println(kthLargestEle);

    }
}

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        return revInorder(root, new int[]{0}, K);
    }

    public int revInorder(Node root, int [] visCount, int k)
    {
        if (root == null)
        {
            return -1;
        }

        // Recurse over right subtree.
        int right = revInorder(root.right, visCount, k);

        if (right != -1)
        {
            return right;
        }

        visCount[0]++;

        if (visCount[0] == k)
        {
            return root.data;
        }

        // Recurse over left subtree.
        int left = revInorder(root.left, visCount, k);

        return left;
    }
}
