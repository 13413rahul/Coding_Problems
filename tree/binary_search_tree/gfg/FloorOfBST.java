package com.company.tree.binary_search_tree.gfg;

// https://www.geeksforgeeks.org/floor-in-binary-search-tree-bst/
public class FloorOfBST {
    static class Node {
        int data;
        Node left, right;
    }

    static int floor(Node root, int key)
    {
        if (root == null)
            return Integer.MAX_VALUE;

        /* If root->data is equal to key */
        if (root.data == key)
            return root.data;

        /* If root->data is greater than the key */
        if (root.data > key)
            return floor(root.left, key);

        /* Else, the floor may lie in right subtree or may be equal to the root*/
        int floorValue = floor(root.right, key);
        return (floorValue <= key) ? floorValue : root.data;
    }
}
