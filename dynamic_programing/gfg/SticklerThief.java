package com.company.dynamic_programing.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
public class SticklerThief {
    static int solve(int arr[],int n,int dp[] ){
        //base case
        if(n<0){
            return 0;
        }

        if(n==0){
            return arr[0];
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int take=solve(arr,n-2,dp)+arr[n];
        int notTake=solve(arr,n-1,dp)+0;

        return dp[n]=Math.max(take,notTake);

    }

    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {   int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(arr,n-1,dp);
    }
}
