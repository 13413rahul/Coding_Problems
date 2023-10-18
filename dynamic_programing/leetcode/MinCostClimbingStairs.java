package com.company.dynamic_programing.leetcode;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    int[] dp = null;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        return Math.min(climb(cost, 0), climb(cost, 1));
    }

    int climb(int[] arr, int index) {
        int sum = 0;
        if(index >= arr.length) {
            return sum;
        }
        if(dp[index] != 0) {
            return dp[index];
        }
        sum += arr[index] + Math.min(climb(arr, index + 1), climb(arr, index + 2));
        dp[index] = sum;
        return sum;
    }
}
