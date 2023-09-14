package com.company.binary_search.leetcode;


// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class smallestLetterGraterThanTarget {
    public char nextGreatestLetter(char[] a, char target)
    {
        int l=0;
        int h=a.length-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(target<a[mid])
            {

                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return a[l%a.length];
    }
}