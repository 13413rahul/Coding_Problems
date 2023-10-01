package com.company.set.leetcode;

import java.util.List;

// https://leetcode.com/problems/minimum-operations-to-collect-elements/description/
public class MinimumOperationsToCollectElements {
    public int minOperations(List<Integer> nums, int k) {
        int a[]=new int[51];
        int size=nums.size();
        for(int i=size-1;i>=0;i--)
        {
            a[nums.get(i)]++;
            int count=0;
            for(int j=1;j<=k;j++)
            {
                if(a[j]>0)
                {
                    count++;
                }
            }
            if(count==k)
            {
                return size-i;
            }
        }
        return size;
    }
}
