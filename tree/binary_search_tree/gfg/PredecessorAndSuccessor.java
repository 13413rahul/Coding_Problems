package com.company.tree.binary_search_tree.gfg;

// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
public class PredecessorAndSuccessor {
    class Node {
        int key;
        Node left, right;

        // BST Node
        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    static Node root;
    static Node pre, suc;

    // This function finds predecessor and successor of key in
// BST. It sets pre and suc as predecessor and successor
// respectively
    public void findPreSuc(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.key == key) {
            // the maximum value in left subtree is predecessor
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                pre = tmp;
            }

            // the minimum value in right subtree is successor
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                suc = tmp;
            }
            return;
        }

        if (root.key > key) {
            suc = root;
            findPreSuc(root.left, key);
        } else {
            pre = root;
            findPreSuc(root.right, key);
        }
    }
}
