package com.company.stack.gfg;

import java.util.ArrayDeque;
import java.util.Deque;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-116/problems
public class IncreasingStack {
    public static void main(String[] args) {
        int n = 5;
        int[] heights = {3, 1, 4, 5, 6};

        Solution solution = new Solution();
        long energy = solution.maximum_energy(n, heights);

        System.out.println(energy);
    }

    static class Solution {
        public long maximum_energy(int n, int[] heights) {
            // code here
            int[] next = new int[n];
            int[] dp = new int[n];
            int ans = 0;

            next[n - 1] = -1;
            Deque<Integer> dq = new ArrayDeque<>();
            dq.offerLast(n - 1);
            for(int i = n - 2; i >= 0; i--) {
                next[i] = -1;

                while(!dq.isEmpty() && heights[dq.peekLast()] <= heights[i]) {
                    dq.pollLast();
                }

                if(!dq.isEmpty()) {
                    next[i] = dq.peekLast();
                }

                dq.offerLast(i);
            }

            for(int i = n - 1; i >= 0; i--) {
                if(next[i] == -1) {
                    dp[i] = heights[i];
                }else {
                    dp[i] = heights[i] ^ dp[next[i]];
                }

                ans = Math.max(ans, dp[i]);
            }

            return ans;
        }
    }

}
