package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        int[] dp2 = new int[n];
        dp2[0] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp2[j] = dp2[j - 1] + dp1[j];
            }

            int[] t = dp2;
            dp2 = dp1;
            dp1 = t;
        }

        return dp1[n - 1];
    }

}
