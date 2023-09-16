package com.company.recursion.gfg;

// https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1
public class CountNumberOfHops {
    //Function to count the number of ways in which frog can reach the top.
    public final int MOD = 1000000007;
    long countWays(int n) {
        // Base cases:
        if (n == 0) return 1; // If we are already at the top, there is one way to reach the top.
        if (n < 0) return 0; // If we go below the ground level, there are no valid ways.

        // Recursive cases:
        long ways = 0;
        ways = (ways + countWays(n - 1)) % MOD; // Take 1 step and calculate the number of ways for the remaining (n-1) steps.
        ways = (ways + countWays(n - 2)) % MOD; // Take 2 steps and calculate the number of ways for the remaining (n-2) steps.
        ways = (ways + countWays(n - 3)) % MOD; // Take 3 steps and calculate the number of ways for the remaining (n-3) steps.

        return ways;
    }
}
