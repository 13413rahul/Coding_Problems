package com.company.dynamic_programing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/description/
public class CountSubtreesWithMaxDistanceBetweenCities {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}};

        Solution solution = new Solution();
        int[] counts = solution.countSubGraphsForEachDiameter(n, edges);
        System.out.println(Arrays.toString(counts));
    }

    static class Solution {
        private List<Integer>[] g;
        private int msk;
        private int nxt;
        private int mx;

        public int[] countSubGraphsForEachDiameter(int n, int[][] edges) {
            g = new List[n];
            Arrays.setAll(g, k -> new ArrayList<>());
            for (int[] e : edges) {
                int u = e[0] - 1, v = e[1] - 1;
                g[u].add(v);
                g[v].add(u);
            }
            int[] ans = new int[n - 1];
            for (int mask = 1; mask < 1 << n; ++mask) {
                if ((mask & (mask - 1)) == 0) {
                    continue;
                }
                msk = mask;
                mx = 0;
                int cur = 31 - Integer.numberOfLeadingZeros(msk);
                dfs(cur, 0);
                if (msk == 0) {
                    msk = mask;
                    mx = 0;
                    dfs(nxt, 0);
                    ++ans[mx - 1];
                }
            }
            return ans;
        }

        private void dfs(int u, int d) {
            msk ^= 1 << u;
            if (mx < d) {
                mx = d;
                nxt = u;
            }
            for (int v : g[u]) {
                if ((msk >> v & 1) == 1) {
                    dfs(v, d + 1);
                }
            }
        }
    }
}
