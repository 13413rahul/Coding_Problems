package com.company.binary_search.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/description/
class MissingNo {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                return nums[i] + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }
}

// TC: O(n * logn) + O(n) => O(n * logn)
// SC: O(1)