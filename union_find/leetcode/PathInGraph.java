package com.company.union_find.leetcode;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class PathInGraph {
    public static void main(String[] args) {
        int noOfVertex = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;

        Solution1 solution = new Solution1();
        boolean isPathExist = solution.validPath(noOfVertex, edges, source, destination);
        System.out.println(isPathExist);
    }
}

class Solution1 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind1 dsu = new UnionFind1(n);
        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        return dsu.find(source) == dsu.find(destination);
    }
}

class UnionFind1 {
    int[] parent;
    int[] size;
    UnionFind1(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    int find(int u) {
        if(u == parent[u]) {
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    void union(int u, int v) {
        int fu = find(u);
        int fv = find(v);
        if(fu == fv) {
            return;
        }

        if(size[fu] < size[fv]) {
            size[fv] += size[fu];
            parent[fu] = fv;
        }else {
            size[fu] += size[fv];
            parent[fv] = fu;
        }
    }
}