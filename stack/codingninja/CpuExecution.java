package com.company.stack.codingninja;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://www.codingninjas.com/studio/problems/execution-time_799892?leftPanelTab=0
public class CpuExecution {
    public static void main(String[] args) {
        int[][] logs = {{0, 1, 1, 0}, {1, 1, -1, -1}, {0, 2, 5, 6}};
        int n = 2;
        int l = 4;

        Solution solution = new Solution();
        int[] execution = solution.exclusiveTime(logs, n, l);
        System.out.println(Arrays.toString(execution));
    }

    static class Solution {
        public static int[] exclusiveTime(int[][] logs, int n, int l) {
            // Write your code here.
            Deque<Integer> dq = new ArrayDeque<>();
            int[] dp = new int[n];
            dq.offerLast(logs[0][0]);

            int prev = logs[2][0];
            for(int i = 1; i < l; i++) {
                if(logs[1][i] == 1) {
                    if(!dq.isEmpty()) {
                        dp[dq.peekLast()] += logs[2][i] - prev;
                    }

                    dq.offerLast(logs[0][i]);
                    prev = logs[2][i];
                }else {
                    dp[dq.pollLast()] += logs[2][i] - prev + 1;
                    prev = logs[2][i] + 1;
                }
            }

            return dp;
        }
    }
}
