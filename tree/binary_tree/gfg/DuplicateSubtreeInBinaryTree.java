package com.company.tree.binary_tree.gfg;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
public class DuplicateSubtreeInBinaryTree {
    class Node {
        int data;
        Node left, right;
    }

    HashMap<String ,Integer> hm = new HashMap<>();
    int dupSub(Node root) {
        solve(root);
        for(String a:hm.keySet()){
            if(hm.get(a)>1)
                return 1;
        }
        return 0;
    }

    String solve(Node root){
        Node curr = root ;
        if(curr == null)
            return "";
        String ans = "";
        String l = solve(curr.left);
        String r = solve(curr.right);
        ans = l+curr.data+r;
        if(curr.left != null || curr.right!= null)
            hm.put(ans,hm.getOrDefault(ans,0)+1);
        return ans;
    }
}
