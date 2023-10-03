package com.company.dynamic_programing.gfg;

// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
public class MaximumSumIncreasingSubsequence {

    // Function to find the maximum sum of an increasing subsequence
    public static int MSIS(int[] nums, int i, int prev, int sum)
    {
        // base case: nothing is remaining
        if (i == nums.length) {
            return sum;
        }

        // case 1: exclude the current element and process the
        // remaining elements
        int excl = MSIS(nums, i + 1, prev, sum);

        // case 2: include the current element if it is greater
        // than the previous element
        int incl = sum;
        if (nums[i] > prev) {
            incl = MSIS(nums, i + 1, nums[i], sum + nums[i]);
        }

        // return the maximum of the above two choices
        return Integer.max(incl, excl);
    }

    public static void main(String[] args)
    {
        int[] nums = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };

        System.out.println("The maximum sum of the increasing subsequence is " + MSIS(nums, 0, Integer.MIN_VALUE, 0));
    }
}
