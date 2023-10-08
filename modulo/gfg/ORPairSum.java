package com.company.modulo.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-123/problems
public class ORPairSum {
    static final int Mod = 1000000000 + 7;
    int orSum(int N, int A[], int M, int B[])
    {
        long[] c1 = new long[30];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 30; j++) {
                c1[j] += (A[i] % 2);
                A[i] /= 2;
            }
        }

        long[] c2 = new long[30];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 30; j++) {
                c2[j] += (B[i] % 2);
                B[i] /= 2;
            }
        }

        long ans = 0;
        for(int i = 0, j = 1; i < 30; i++, j *= 2) {
            ans = (ans + (((c1[i] * c2[i] + c1[i] * (M - c2[i]) + c2[i] * (N - c1[i])) % Mod) * j) % Mod) % Mod;
        }

        return (int)ans;
    }
}
