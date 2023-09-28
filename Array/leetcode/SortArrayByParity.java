package com.company.Array.leetcode;

// https://leetcode.com/problems/sort-array-by-parity/description/?envType=daily-question&envId=2023-09-28
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            while (i < j && nums[i] % 2 == 0)
                i++;
            while (i < j && nums[j] % 2 == 1)
                j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
