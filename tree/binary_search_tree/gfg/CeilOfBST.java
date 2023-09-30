package com.company.tree.binary_search_tree.gfg;

// https://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/
public class CeilOfBST {
    class Node {

        int data;
        Node left, right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    Node root;

    // Function to find ceil of a given input in BST.
    // If input is more than the max key in BST,
    // return -1
    int Ceil(Node node, int input)
    {

        // Base case
        if (node == null) {
            return -1;
        }

        // We found equal key
        if (node.data == input) {
            return node.data;
        }

        // If root's key is smaller,
        // ceil must be in right subtree
        if (node.data < input) {
            return Ceil(node.right, input);
        }

        // Else, either left subtree or root
        // has the ceil value
        int ceil = Ceil(node.left, input);

        return (ceil >= input) ? ceil : node.data;
    }
}
