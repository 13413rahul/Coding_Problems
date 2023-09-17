package com.company.Array.leetcode;

import java.util.List;

// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/
public class SumOfValuesAtIndicesWithKSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int index = i;
            int setBits = 0;

            // Count the number of set bits in the binary representation of the index.
            while (index > 0) {
                setBits += index & 1;
                index >>= 1;
            }

            // Check if the count of set bits matches k.
            if (setBits == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

}
