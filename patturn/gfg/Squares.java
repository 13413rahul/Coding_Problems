package com.company.patturn.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-123/problems
public class Squares {
    int squares(int N, int X)
    {
        // code here
        long side = (1 << N);
        long total = side * side;
        if(X > total) {
            return -1;
        }

        X--;
        int ans = X / 3;
        if(X % 3 != 0) {
            ans++;
        }

        return ans;
    }
}
