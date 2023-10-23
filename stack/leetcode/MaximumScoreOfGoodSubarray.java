package com.company.stack.leetcode;

// https://leetcode.com/problems/maximum-score-of-a-good-subarray/description/?envType=daily-question&envId=2023-10-22
public class MaximumScoreOfGoodSubarray {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int min_val = nums[k];
        int max_score = min_val;

        while (left > 0 || right < nums.length - 1) {
            if (left == 0 || (right < nums.length - 1 && nums[right + 1] > nums[left - 1])) {
                right++;
            } else {
                left--;
            }
            min_val = Math.min(min_val, Math.min(nums[left], nums[right]));
            max_score = Math.max(max_score, min_val * (right - left + 1));
        }

        return max_score;
    }
}
