package com.company.bfs.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/eventual-safe-states/1
public class EventualSafeStates {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> safeNodes=new ArrayList<>();
        int[] state=new int[V];
        for(int i=0; i<V; i++) {
            if(isSafeNode(i, adj, state)) safeNodes.add(i);
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    private boolean isSafeNode(int node, List<List<Integer>> adj, int[] state) {
        if(state[node]!=0) return state[node]==2;
        state[node]=1;
        for(int neighbour:adj.get(node)) {
            if(!isSafeNode(neighbour, adj, state)) return false;
        }
        state[node]=2;
        return true;
    }
}
