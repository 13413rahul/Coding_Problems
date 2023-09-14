package com.company.prime.gfg;

// https://practice.geeksforgeeks.org/problems/perfect-numbers3207/1
public class FactorSumToNumber {
    public static void main(String[] args) {
        long N = 10;

        Solution solution = new Solution();
        int isFactorSumToNumber = solution.isPerfectNumber(N);
        System.out.println(isFactorSumToNumber);
    }

    static class Solution {
        static int isPerfectNumber(long N) {
            // code here
            if(N <= 1) {
                return 0;
            }

            long sum = 1;
            for(long i = 2; i * i <= N; i++) {
                if(N % i == 0) {
                    sum += i;
                    if(i * i != N) {
                        sum += N / i;
                    }
                }
            }

            return sum == N ? 1 : 0;
        }
    };
}
