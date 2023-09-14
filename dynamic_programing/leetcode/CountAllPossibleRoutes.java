package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/count-all-possible-routes/description/
public class CountAllPossibleRoutes {
    public static void main(String[] args) {
        int[] locations = {2,3,6,8,4};
        int start = 1, finish = 3, fuel = 5;

        Solution solution = new Solution();
        int count = solution.countRoutes(locations, start, finish, fuel);
        System.out.println(count);
    }

    static class Solution {
        public int solve(int[] locations, int currCity, int finish, int remainingFuel, int memo[][]) {
            if (remainingFuel < 0) {
                return 0;
            }
            if (memo[currCity][remainingFuel] != -1) {
                return memo[currCity][remainingFuel];
            }

            int ans = currCity == finish ? 1 : 0;
            for (int nextCity = 0; nextCity < locations.length; nextCity++) {
                if (nextCity != currCity) {
                    ans = (ans + solve(locations, nextCity, finish,
                            remainingFuel - Math.abs(locations[currCity] - locations[nextCity]),
                            memo)) % 1000000007;
                }
            }

            return memo[currCity][remainingFuel] = ans;
        }

        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            int n = locations.length;
            int memo[][] = new int[n][fuel + 1];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(memo[i], -1);
            }

            return solve(locations, start, finish, fuel, memo);
        }
    }
}
