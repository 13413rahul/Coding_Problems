package com.company.dynamic_programing.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
public class EggDropping {

    //Function to find minimum number of attempts needed in
    //order to find the critical floor.
    static int eggDrop(int e, int f)
    {
        // Your code here
        int dp[][]=new int[e+1][f+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        int ans=solve(e,f,dp);
        return ans;

    }

    static int solve(int e,int f,int dp[][]){

        if(e==1){
            return f;
        }

        if(f==0 || f==1){
            return f;
        }


        if(dp[e][f]!=-1)
            return dp[e][f];

        int res=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            int low,high;
            if(dp[e-1][k-1]!=-1){
                low=dp[e-1][k-1];
            }
            else{
                low=solve(e-1,k-1,dp);
                dp[e-1][k-1]=low;

            }


            if(dp[e][f-k]!=-1){
                high=dp[e][f-k];
            }
            else{
                high=solve(e,f-k,dp);
                dp[e][f-k]=high;
            }
            // int low=eggDrop(e-1,k-1);
            // int high=eggDrop(e,f-k);
            int temp=1+Math.max(low,high);
            res=Math.min(res,temp);
        }

        return dp[e][f]=res;

    }
}
