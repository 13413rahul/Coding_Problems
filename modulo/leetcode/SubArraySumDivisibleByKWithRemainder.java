package com.company.modulo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/count-of-interesting-subarrays/description/
public class SubArraySumDivisibleByKWithRemainder {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 1, 9, 6);
        int modulo = 3;
        int k = 0;

        Solution solution = new Solution();
        long count = solution.countInterestingSubArrays(nums, modulo, k);
        System.out.println(count);
    }

    static class Solution {
        public long countInterestingSubArrays(List<Integer> nums, int modulo, int k) {
            int sum = 0;
            Map<Integer, Long> dp = new HashMap<>();
            long ans = 0;
            dp.put(0, 1l);
            for(int num : nums) {
                if(num % modulo == k) {
                    sum++;
                }

                ans += dp.getOrDefault((sum - k + modulo) % modulo, 0l);
                dp.put(sum % modulo, dp.getOrDefault(sum % modulo, 0l) + 1);
            }

            return ans;
        }
    }
}


