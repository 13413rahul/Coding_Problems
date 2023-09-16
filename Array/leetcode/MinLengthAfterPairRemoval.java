package com.company.Array.leetcode;

import java.util.List;

// https://leetcode.com/problems/minimum-array-length-after-pair-removals/description/
public class MinLengthAfterPairRemoval {

    public int minLengthAfterRemovals(List<Integer> nums) {
        int i = 0;
        int max = 0;
        while(i < nums.size()) {
            int j = i + 1;
            while(j < nums.size() && nums.get(i) == nums.get(j)) {
                j++;
            }

            int temp = j - i;
            if(temp > 1) {
                max = Math.max(temp, max);
            }
            i = j;
        }

        int cnt = 0;

        int distinct = nums.size() - max;
        if(distinct >= max) {
            if(nums.size() % 2 != 0) cnt++;
        }
        else cnt += max - distinct;
        return cnt;
    }

}
