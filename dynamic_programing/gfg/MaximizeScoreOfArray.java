package com.company.dynamic_programing.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/contest/job-a-thon-hiring-challenge-experienced-professionals/problems
public class MaximizeScoreOfArray {
    public long MaximumScore(int N, int K, int arr[]) {
        // Code Here.

        long[] dp = new long[N];
        Arrays.fill(dp, -1);

        return rec(0, K, N, dp, arr);
    }

    long rec(int i, int k, int n, long[] dp, int[] arr)  {
        if(i >= n) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        if(n - i < k) {
            return dp[i] = Long.MIN_VALUE;
        }

        int max = -1;
        int count = 0;
        for(int j = i; j < Math.min(i + 2 * k - 1, n); j++) {
            max = Math.max(arr[j], max);
            count++;
            if(count >= k) {
                dp[i] = Math.max(dp[i], max + rec(j + 1, k, n, dp, arr));
            }
        }

        return dp[i];
    }
}
