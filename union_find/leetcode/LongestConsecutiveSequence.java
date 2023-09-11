package com.company.union_find.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        Solution2 solution = new Solution2();
        int length = solution.longestConsecutive(nums);
        System.out.println(length);
    }
}

class Solution2 {
    public int longestConsecutive(int[] nums) {
        UnionFind2 uf = new UnionFind2();
        for(int num : nums) {
            if(!uf.parent.containsKey(num)) {
                uf.parent.put(num, num);
                uf.size.put(num, 1);

                if(uf.parent.containsKey(num - 1)) {
                    uf.union(num, num - 1);
                }

                if(uf.parent.containsKey(num + 1)) {
                    uf.union(num, num + 1);
                }
            }
        }

        int ans = 0;
        for(int k : uf.size.keySet()) {
            ans = Math.max(ans, uf.size.get(k));
        }

        return ans;
    }
}

class UnionFind2 {
    Map<Integer, Integer> parent, size;
    UnionFind2() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    int find(int node) {
        if(node == parent.get(node)) {
            return node;
        }

        parent.put(node, find(parent.get(node)));
        return parent.get(node);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) {
            return;
        }

        if(pu < pv) {
            size.put(pv, size.get(pu) + size.get(pv));
            parent.put(pu, pv);
        }else {
            parent.put(pv, pu);
            size.put(pu, size.get(pu) + size.get(pv));
        }
    }
}
