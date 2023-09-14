package com.company.dynamic_programing.leetcode;

// https://leetcode.com/problems/cherry-pickup-ii/description/
public class CherryPickUo11 {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,0,0,1}, {2,0,0,0,0,3,0}, {2,0,9,0,0,0,0}, {0,3,0,5,4,0,0}, {1,0,2,3,0,0,6}};

        Solution solution = new Solution();
        int collectedCherries = solution.cherryPickup(grid);
        System.out.println(collectedCherries);
    }

    static class Solution {
        public int cherryPickup(int[][] grid) {
            int[][][] dp = new int[grid.length + 1][grid[0].length + 1][grid[0].length + 1];
            for(int i = 0; i <= grid.length; i++) {
                for(int j = 0; j <= grid[0].length; j++) {
                    for(int k = 0; k <= grid[0].length; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }

            return dfs(0, 0, grid[0].length - 1, grid, dp);
        }

        int dfs(int i, int r1, int r2, int[][] grid, int[][][] dp) {
            if(r1 < 0 || r1 >= grid[0].length || r2 < 0 || r2 >= grid[0].length) {
                return -1;
            }

            if(i == grid.length - 1) {
                if(r1 == r2) {
                    return grid[i][r1];
                }else {
                    return grid[i][r1] + grid[i][r2];
                }
            }

            if(dp[i][r1][r2] != -1) {
                return dp[i][r1][r2];
            }

            int max = -1;
            for(int dr1 = -1; dr1 <= 1; dr1++) {
                for(int dr2 = -1; dr2 <= 1; dr2++) {
                    int v = 0;
                    if(r1 == r2) {
                        v = grid[i][r1];
                    }else {
                        v = grid[i][r1] + grid[i][r2];
                    }
                    v += dfs(i + 1, r1 + dr1, r2 + dr2, grid, dp);
                    max = Math.max(max, v);
                }
            }

            return dp[i][r1][r2] = max;
        }
    }
}
