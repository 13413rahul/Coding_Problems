package com.company.hashmap.leetcode;

import java.util.HashMap;

// https://leetcode.com/problems/number-of-good-pairs/description/?envType=daily-question&envId=2023-10-03
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            result += count.get(num) - 1;
        }

        return result;
    }
}
