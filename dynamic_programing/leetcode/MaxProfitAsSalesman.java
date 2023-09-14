package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximize-the-profit-as-the-salesman/description/
public class MaxProfitAsSalesman {
    public static void main(String[] args) {
        int n = 5, offers[][] = {{0,0,1},{0,2,10},{1,3,2}};
        Solution solution = new Solution();
        int profit = solution.maximizeTheProfit(n, offers);
        System.out.println(profit);
    }

    static class Solution {
        int[] dp = new int[100001];

        int search(int[][] v, int i, int m) {
            int l = i + 1, h = m - 1;
            int k = -1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (v[mid][0] > v[i][1]) {
                    k = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return k;
        }

        int solve(int i, int[][] v, int m) {
            if (i >= m)
                return 0;
            if (dp[i] != -1)
                return dp[i];
            int a = solve(i + 1, v, m);
            int k = search(v, i, m);
            int b = v[i][2];
            if (k != -1)
                b = v[i][2] + solve(k, v, m);
            dp[i] = Math.max(a, b);
            return dp[i];
        }

        public int maximizeTheProfit(int n, int[][] v) {
            Arrays.fill(dp, -1);
            Arrays.sort(v, (a, b) -> Integer.compare(a[0], b[0]));
            int m = v.length;
            int ans = solve(0, v, m);
            return ans;
        }
    }
}
