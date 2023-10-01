package com.company.sliding_window.leetcode;

// https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays/description/
public class SplitArrayIntoMaximumNumberOfSubarrays {
    public int maxSubarrays(int[] A) {
        int v = -1, res = 0;
        for (int a: A) {
            v &= a;
            if (v == 0) {
                v = -1;
                res += 1;
            }
        }
        return Math.max(1, res);
    }
}
