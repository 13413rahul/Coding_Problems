package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/?envType=daily-question&envId=2023-10-15
public class NOOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public int numWays(int steps, int arrLen) {
        int MOD = 1000000007;
        int[][] memo = new int[steps + 1][Math.min(arrLen, steps) + 1];

        for (int i = 0; i <= steps; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(steps, 0, arrLen, MOD, memo);
    }

    private int dp(int step, int index, int arrLen, int MOD, int[][] memo) {
        if (step == 0) {
            return (index == 0) ? 1 : 0;
        }
        if (step < 0 || index < 0 || index >= arrLen) {
            return 0;
        }
        if (memo[step][index] != -1) {
            return memo[step][index];
        }

        long ways = dp(step - 1, index, arrLen, MOD, memo) % MOD;
        ways += dp(step - 1, index - 1, arrLen, MOD, memo) % MOD;
        ways += dp(step - 1, index + 1, arrLen, MOD, memo) % MOD;

        memo[step][index] = (int)(ways % MOD);
        return (int)(ways % MOD);
    }
}
