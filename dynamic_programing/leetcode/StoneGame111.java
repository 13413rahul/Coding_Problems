package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/stone-game-iii/description/
public class StoneGame111 {
    public static void main(String[] args) {
        int[] stoneValue = {1,2,3,-9};

        Solution solution = new Solution();
        String whoWin = solution.stoneGameIII(stoneValue);
        System.out.println(whoWin);
    }

    static class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int[] dp = new int[stoneValue.length];
            Arrays.fill(dp, -1);

            int d = method(0, stoneValue, stoneValue.length, dp);
            if(d > 0) {
                return "Alice";
            }else if(d < 0) {
                return "Bob";
            }else {
                return "Tie";
            }
        }

        int method(int i, int[] stoneValue, int n, int[] dp) {
            if(i >= n) {
                return 0;
            }

            if(dp[i] != -1) {
                return dp[i];
            }

            int r = stoneValue[i] - method(i + 1, stoneValue, n, dp);

            if(i + 2 <= n) {
                r = Math.max(r, stoneValue[i] + stoneValue[i + 1] - method(i + 2, stoneValue, n, dp));
            }

            if(i + 3 <= n) {
                r = Math.max(r, stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - method(i + 3, stoneValue, n, dp));
            }

            return dp[i] = r;
        }
    }
}
