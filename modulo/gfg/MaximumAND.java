package com.company.modulo.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-122/problems
public class MaximumAND {
    int maxAnd(int N, int A[])
    {
        // code here
        int[] count = new int[32];
        for(int a : A) {
            for(int i = 0; i < 32; i++) {
                if((a & (1 << i)) == 0) {
                    count[i]++;
                }
            }
        }

        int max = 0;
        for(int a : A) {
            int ans = 0;
            for(int i = 0; i < 32; i++) {
                if((a & (1 << i)) == 0) {
                    if(count[i] - 1 <= 0) {
                        ans += 1 * (1 << i);
                    }
                }else {
                    if(count[i] <= 0) {
                        ans += 1 * (1 << i);
                    }
                }
            }

            max = Math.max(max, ans);
        }

        return max;
    }
}
