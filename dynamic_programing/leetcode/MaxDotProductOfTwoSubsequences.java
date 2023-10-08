package com.company.dynamic_programing.leetcode;

// https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/?envType=daily-question&envId=2023-10-08
public class MaxDotProductOfTwoSubsequences {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }

        return dp(nums1, nums2, 0, 0, memo);
    }

    private int dp(int[] nums1, int[] nums2, int i, int j, int[][] memo) {
        int n = nums1.length;
        int m = nums2.length;

        if (i == n || j == m) {
            return Integer.MIN_VALUE;
        }

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        memo[i][j] = Math.max(
                nums1[i] * nums2[j] + Math.max(dp(nums1, nums2, i + 1, j + 1, memo), 0),
                Math.max(dp(nums1, nums2, i + 1, j, memo), dp(nums1, nums2, i, j + 1, memo))
        );

        return memo[i][j];
    }

}
