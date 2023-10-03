package com.company.dynamic_programing.gfg;

// https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
public class PalindromePartitioning {
    public static int f(int i, int n, String s, int[] dp){
        if(i==n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int minCost =Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            if(isPalindrome(s,i,j)){
                int cost = 1+f(j+1, n ,s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return f(0,n,str,dp)-1;
    }
}
