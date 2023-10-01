package com.company.modulo.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-122/problems
public class NaughtyGeek {
    public static long totalWays(int N) {
        // code here
        long prod = 1;
        for(int i = 1; i <= N; i++) {
            prod *= i;
        }

        return prod;
    }
}
