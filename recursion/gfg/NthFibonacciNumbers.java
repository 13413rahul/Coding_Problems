package com.company.recursion.gfg;

// https://practice.geeksforgeeks.org/problems/print-first-n-fibonacci-numbers1002/1
public class NthFibonacciNumbers {
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibonacci(int n)
    {
        //Your code here
        long[] ans = new long[n];
        if(n == 1) {
            ans[0] = 1;
            return ans;
        }
        if(n == 2) {
            ans[0] = 1;
            ans[1] = 1;
            return ans;
        }

        ans[0] = 1;
        ans[1] = 1;
        for(int i = 2; i < n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }

        return ans;
    }
}
