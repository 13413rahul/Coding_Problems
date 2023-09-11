package com.company.hashmap.leetcode;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
public class SubArraySumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        Solution solution = new Solution();
        long count = solution.subArraysDivByK(nums, k);
        System.out.println(count);
    }

    static class Solution {
        public int subArraysDivByK(int[] nums, int k) {
            int sum = 0;
            int count = 0;
            int[] dp = new int[k];
            dp[0] = 1;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                count += dp[(k + sum % k) % k];
                dp[(k + sum % k) % k]++;
            }

            return count;
        }
    }
}


