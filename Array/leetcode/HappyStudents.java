package com.company.Array.leetcode;

import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/happy-students/
public class HappyStudents {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count = 0;
        int student = 0;
        if(count < nums.get(0)) {
            count++;
        }

        for(int i = 0; i < nums.size() - 1; i++) {
            student++;
            if(nums.get(i) < student && nums.get(i + 1) > student) {
                count++;
            }

        }

        if(nums.get(nums.size() - 1) < student + 1) {
            count++;
        }

        return count;
    }

}
