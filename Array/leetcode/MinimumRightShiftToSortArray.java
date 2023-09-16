package com.company.Array.leetcode;

import java.util.List;

// https://leetcode.com/contest/biweekly-contest-113/problems/minimum-right-shifts-to-sort-the-array
public class MinimumRightShiftToSortArray {

    public int minimumRightShifts(List<Integer> nums) {
        int ind = 0, c = 0;
        for(int i = 1; i<nums.size(); i++){
            if(nums.get(i - 1) > nums.get(i)){     // Check prev number is greater than curr
                ind = i;
                c++;        // And Count those occurences
            }
        }
        if(c > 1){           // If greater than 1 then we cannot rotate the array into sorted form
            return -1;
        }
        if(ind == 0){   return 0;  }
        return nums.get(nums.size() - 1) > nums.get(0) ? -1 : nums.size() - ind;
    }

}
