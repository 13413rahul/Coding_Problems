package com.company.patturn.gfg;

// https://practice.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
public class SumOfAllDivisorsFrom1Ton {
    static long sumOfDivisors(int N){
        // code here
        long sum = 0;
        for(int i=1;i<=N;i++){
            sum = sum + i*(N/i);
        }
        return sum;
    }
}
