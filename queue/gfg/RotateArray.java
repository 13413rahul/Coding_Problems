package com.company.queue.gfg;

import java.util.ArrayDeque;
import java.util.Deque;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-116/problems
public class RotateArray {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] brr = {2, 1, 3};
        Solution solution = new Solution();
        int minOperation = solution.min_operations(n, arr, brr);
        System.out.println(minOperation);

    }

    static class Solution {
        public int min_operations(int n, int[] arr, int[] brr) {
            // code here
            Deque<Integer> dq = new ArrayDeque<>();
            int i = 0;
            for(int t : arr) {
                dq.offerLast(t);
            }

            int count = 0;
            while(!dq.isEmpty()) {
                if(dq.peekFirst() != brr[i]) {
                    dq.offerLast(dq.pollFirst());
                }
                else {
                    dq.pollFirst();
                    i++;
                }
                count++;
            }

            return count;
        }
    }
}



