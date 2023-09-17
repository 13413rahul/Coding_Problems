package com.company.hashmap.gfg;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
public class LongestSubArraySumZero {
    public int maxLen(int A[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for(int i = 0;i<n;i++) {

            sum += A[i];

            if(sum == 0) {
                maxi = i + 1;
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
