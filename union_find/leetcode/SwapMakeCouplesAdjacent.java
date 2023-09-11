package com.company.union_find.leetcode;

// https://leetcode.com/problems/couples-holding-hands/description/
public class SwapMakeCouplesAdjacent {
    public static void main(String[] args) {
        int[] row = {0,2 ,1, 3};

        Solution4 solution = new Solution4();
        int noOfSwap = solution.minSwapsCouples(row);
        System.out.println(noOfSwap);
    }
}

class Solution4 {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UnionFind4 uf = new UnionFind4(n);
        for(int i = 0; i < n; i += 2) {
            uf.union(row[i], row[i + 1]);
        }

        int count = 0;
        for(int i = 0; i < n; i += 2) {
            if(uf.union(i, i + 1)) {
                count++;
            }
        }

        return count;
    }
}

class UnionFind4 {
    int[] parent;
    UnionFind4(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int n) {
        if(n == parent[n]) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }

    boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) {
            return false;
        }

        parent[pv] = pu;

        return true;
    }
}
