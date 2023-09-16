package com.company.binary_search.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/intersection-of-two-arrays/description/
class IntersecterInTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1[0]==nums2[nums2.length-1]) return new int[]{nums1[0]};
        if(nums1[nums1.length-1]==nums2[0]) return new int[]{nums2[0]};
        ArrayList<Integer> ar=new ArrayList<>();
        int prev=-1;
        for(int i=0;i<nums1.length;i++){
            int comm=getCommon(nums2,nums1[i]);
            if(comm>prev){     //to avoid repetition
                ar.add(comm);
                prev=comm;
            }
        }

        int ans[]=new int[ar.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=ar.get(i);
        }

        return ans;
    }

    public int getCommon(int arr[], int val){   //Binary Search
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=i+((j-i)/2);
            if(arr[mid]==val) return val;
            else if(arr[mid]<val) i=mid+1;
            else j=mid-1;
        }
        return -1;
    }
}