package com.company.dynamic_programing.gfg;

// https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1
public class NthCatalanNumber {
    public static void main(String[] args) {
        int n = 100;
        Solution solution = new Solution();
        int v= solution.findCatalan(n);
        System.out.println(v);
    }

    static class Solution {
        public static int findCatalan(int n) {
            // code here
            return catalanDP(n);
        }

        // A dynamic programming based function to find nth
        // Catalan number
        private static int catalanDP(int n)
        {
            // Table to store results of subproblems
            long catalan[] = new long[n + 2];

            // Initialize first two values in table
            catalan[0] = 1;
            catalan[1] = 1;

            // Fill entries in catalan[]
            // using recursive formula
            for (int i = 2; i <= n; i++) {
                catalan[i] = 0;
                for (int j = 0; j < i; j++) {
                    catalan[i] = (catalan[i] + catalan[j]  * catalan[i - j - 1]) % (1000000000 + 7);
                }
            }

            // Return last entry
            return (int)(catalan[n] % (1000000000 + 7));
        }
    }
}
