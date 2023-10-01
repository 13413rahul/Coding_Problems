package com.company.string.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-122/problems
public class SpacialString {
    final int MOD = 1000000000 + 7;
    int specialStrings(int N, String S) {
        // Code here.
        long[][][][] dp = new long[N + 1][27][27][2];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= 26; j++) {
                for(int k = 0; k <= 26; k++) {
                    dp[i][j][k][0] = -1;
                    dp[i][j][k][1] = -1;
                }
            }
        }

        return (int)rec(0, 26, 26, 0, S, dp);
    }

    long rec(int i, int last, int secoundLast, int large, String s, long[][][][] dp) {
        if(i >= s.length()) {
            return large;
        }

        if(dp[i][last][secoundLast][large] != -1) {
            return dp[i][last][secoundLast][large];
        }

        long ans = 0;
        int curr = s.charAt(i) - 'a';
        if(large == 1) {
            curr = 0;
        }

        for(int j = curr; j < 26; j++) {
            if(j == last || j == secoundLast) {
                continue;
            }

            int ok = large;
            if(j > curr) {
                ok = 1;
            }

            ans += rec(i + 1, j, last, ok, s, dp);
            ans %= MOD;
        }

        return dp[i][last][secoundLast][large] = ans;
    }
}
