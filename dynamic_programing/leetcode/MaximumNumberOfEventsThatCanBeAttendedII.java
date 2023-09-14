package com.company.dynamic_programing.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/
public class MaximumNumberOfEventsThatCanBeAttendedII {
    public static void main(String[] args) {
        int[][] events = {{1,2,4},{3,4,3},{2,3,1}};
        int k = 2;

        Solution solution = new Solution();
        int value = solution.maxValue(events, k);
        System.out.println(value);
    }

    static class Solution {
        public int maxValue(int[][] events, int k) {
            Arrays.sort(events, (a, b) -> a[0] - b[0]);
            int n = events.length;

            dp = new int[k + 1][n];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return dfs(0, k, events);
        }

        private int[][] dp;
        private int dfs(int curIndex, int count, int[][] events) {
            if (count == 0 || curIndex == events.length) {
                return 0;
            }
            if (dp[count][curIndex] != -1) {
                return dp[count][curIndex];
            }
            int nextIndex = bisectRight(events, events[curIndex][1]);
            dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events), events[curIndex][2] + dfs(nextIndex, count - 1, events));
            return dp[count][curIndex];
        }

        public static int bisectRight(int[][] events, int target) {
            int left = 0, right = events.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (events[mid][0] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
