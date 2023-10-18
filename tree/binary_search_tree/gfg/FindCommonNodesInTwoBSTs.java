package com.company.tree.binary_search_tree.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
public class FindCommonNodesInTwoBSTs {
    class Node {
        int data;
        Node left, right;
    }

    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        //code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root1);

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(search(root2,curr.data)){
                ans.add(curr.data);
            }
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static boolean search(Node root, int key){
        if(root==null)return false;

        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }
}
