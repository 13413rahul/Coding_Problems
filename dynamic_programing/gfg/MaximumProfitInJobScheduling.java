package com.company.dynamic_programing.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        // sort jobs by time asc
        Arrays.sort(jobs, (a, b)-> a[0] - b[0]);

        return scheduling(jobs, 0, new Integer[jobs.length + 1]);
    }

    private int scheduling(int[][] jobs, int index, Integer[] dp){
        if(index >= jobs.length){
            return 0;
        }

        if(dp[index] != null){
            return dp[index];
        }

        // excluding current
        int profit1 = scheduling(jobs, index + 1, dp);

        // including current - init profit2 with current job amount
        int profit2 = jobs[index][2];

        int nextIndex = calculateNextIndex(jobs, jobs[index], index);
        if(nextIndex != -1){
            profit2 += scheduling(jobs, nextIndex, dp);
        }

        dp[index] = Math.max(profit1, profit2);
        return dp[index];
    }

    private int calculateNextIndex(int[][] jobs, int[] job, int index){
        int left = index;
        int right = jobs.length - 1;
        int pos = -1;

        while(left <= right){
            int middle = left + (right - left) / 2;

            int jobStart = jobs[middle][0];
            int currentJobEnd = job[1];

            if(jobStart >= currentJobEnd){
                pos = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return pos;
    }
}


