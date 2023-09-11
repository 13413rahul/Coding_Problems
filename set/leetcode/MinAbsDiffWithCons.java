package com.company.set.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/
public class MinAbsDiffWithCons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        List<Integer> nums = new ArrayList<>();
//        for(int i = 0; i < size; i++) {
//            int ele = sc.nextInt();
//            nums.add(ele);
//        }
//        int x = sc.nextInt();

        List<Integer> nums = List.of(4, 3, 2, 4);
        int x = 2;

        Solution solution = new Solution();
        int minAbsDiff = solution.minAbsoluteDifference(nums, x);
        System.out.println(minAbsDiff);

    }
}

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans=Integer.MAX_VALUE;
        TreeSet<Integer> nm=new TreeSet<>();
        int size=nums.size();
        for(int i=x;i<size;i++)
        {
            nm.add(nums.get(i-x));
            Integer val=nm.ceiling(nums.get(i));
            if(val!=null)
            {
                ans=Math.min(ans,Math.abs(nums.get(i)-val));
            }
            Integer val1=nm.floor(nums.get(i));
            if(val1!=null)
            {
                ans=Math.min(ans,Math.abs(nums.get(i)-val1));
            }
        }
        return ans;
    }
}
