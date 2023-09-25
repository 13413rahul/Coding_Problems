package com.company.dynamic_programing.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-120-1628/problems
public class MaxRemoval {
    int f(int i,int j,int x,int arr[],int n,int dp[][],int picked[]){
        if(j==x){
            return 1;
        }

        if(j>x || i>=n){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int op1=f(i+1,j,x,arr,n,dp,picked);

        int op2=f(i+1,j+arr[i],x,arr,n,dp,picked);

        if(op2!=0){
            picked[i]=1;
        }

        int ans=op1+op2;
        dp[i][j]=ans;
        return ans;


    }

    int maxRemoval(int N, int A[], int X)
    {
        // code here
        int dp[][]=new int[N][X+1];
        int picked[]=new int[N];


        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }

        f(0,0,X,A,N,dp,picked);
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=picked[i];
        }

        return N-sum;

    }
}
