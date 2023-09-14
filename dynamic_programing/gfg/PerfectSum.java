package com.company.dynamic_programing.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1
public class PerfectSum {
    public static void main(String[] args) {
        int N = 6, arr[] = {2, 3, 5, 6, 8, 10}, sum = 10;
        Solution solution = new Solution();
        int countOfArray = solution.perfectSum(arr, N, sum);
        System.out.println(countOfArray);
    }

    static class Solution{
        public int perfectSum(int arr[],int n, int sum)
        {
            // Your code goes here
            int MOD = 1000000007;
            int[] dp = new int[sum + 1];
            Arrays.fill(dp, 0);
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = sum; j >= arr[i]; j--) {
                    dp[j] += dp[j - arr[i]];
                    dp[j] %= MOD;
                }
            }
            return dp[sum];

        }
    }
}
