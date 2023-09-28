package com.company.tree.binary_tree.gfg;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewOfBST {
    static class Node {
        Node left;
        Node right;
        int data;
        int hd;
    }

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>();
        root.hd = 0;
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.remove();
            int hd = temp.hd;
            map.put(hd, temp.data);
            if(temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if(temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }
}