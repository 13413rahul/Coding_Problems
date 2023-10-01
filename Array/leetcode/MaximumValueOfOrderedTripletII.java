package com.company.Array.leetcode;

// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-ii/
public class MaximumValueOfOrderedTripletII {
    public long maximumTripletValue(int[] A) {
        long res = 0, maxa = 0, maxab = 0;
        for (int a : A) {
            res = Math.max(res, 1L * maxab * a);
            maxab = Math.max(maxab, maxa - a);
            maxa = Math.max(maxa, a);
        }
        return res;
    }

    long getHelp(int[] nums) {
        int[] suffMax = new int[nums.length];
        suffMax[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            suffMax[i] = Math.max(nums[i + 1], suffMax[i + 1]);
        }

        long maxAns = 0;
        int max = nums[0];
        for(int j = 1; j < nums.length - 1; j++) {
            maxAns = Math.max(maxAns, 1l * (max - nums[j]) * suffMax[j]);
            max = Math.max(max, nums[j]);
        }

        return maxAns;
    }
}
