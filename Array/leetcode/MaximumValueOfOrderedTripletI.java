package com.company.Array.leetcode;

// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-i/
public class MaximumValueOfOrderedTripletI {
    public long maximumTripletValue(int[] nums) {
        long max= Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, 1l * (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return max < 0 ? 0 : max;
    }
}
