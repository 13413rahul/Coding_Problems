package com.company.binary_search.gfg;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
public class FirstAndLastOccurrencesOfX {
    public static int find(int arr[],int n,int x,boolean f) {
        int start = 0,end = n-1,mid = 0,ans = -1;

        while(start <= end) {
            mid = start + (end - start)/2;
            if(arr[mid] >  x) {
                end = mid - 1;
            } else if(arr[mid] < x) {
                start = mid + 1;
            } else {
                ans = mid;
                if(f) {
                    end = mid-1;
                } else{
                    start = mid + 1;
                }
            }
        }

        return ans;
    }

    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer>  list = new ArrayList<>();
        list.add(find(arr,n,x,true));
        list.add(find(arr,n,x,false));
        return list;
    }
}
