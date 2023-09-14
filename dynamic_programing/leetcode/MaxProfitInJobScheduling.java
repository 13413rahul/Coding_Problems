package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
public class MaxProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6}, endTime = {3,5,10,6,9}, profit = {20,20,100,70,60};
        Solution solution = new Solution();
        int maxProfit = solution.jobScheduling(startTime, endTime, profit);
        System.out.println(maxProfit);
    }

    static class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n=startTime.length;
            int[][] events=new int[n][3];
            for(int i=0;i<n;i++){
                events[i][0]=startTime[i];
                events[i][1]=endTime[i];
                events[i][2]=profit[i];
            }
            Arrays.sort(events,(a, b)->Integer.compare(a[0], b[0]));
            Integer[] dp=new Integer[n];
            return dfs(events,0,n,dp);
        }

        public int dfs(int[][] events, int idx, int n,Integer[] dp){
            if(idx==n)return 0;
            if(dp[idx]!=null)return dp[idx];
            int nextIdx=findNext(events, idx,n);
            int pick=events[idx][2]+dfs(events, nextIdx, n,dp);
            int notPick=dfs(events, idx+1, n,dp);
            return dp[idx]= Math.max(pick,notPick);
        }
        public int findNext(int[][] events, int idx, int n){
            int ans=n;
            int l=idx+1;
            int r=n-1;
            while(l<=r){
                int mid=(l+r)>>1;
                if(events[idx][1]<=events[mid][0]){
                    ans=mid;
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
            return ans;
        }
    }
}
