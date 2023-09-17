package com.company.recursion.leetcode;

// https://leetcode.com/problems/powx-n/description/
public class Pow {
    public double myPow(double x, int n) {
        return rec(x, (long) n);
    }

    double rec(double x, long n) {
        if(n < 0) {
            return 1.0 /  rec(x, -1 * n);
        }

        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }

        double t = rec(x, n / 2);
        if(n % 2 == 0) {
            return t * t;
        }else {
            return x * t * t;
        }
    }
}
