package com.company.heap.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/maximum-sum-combination/1
public class MaximumSumCombination {
    // User function Template for Java

    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int num : A) {
            pq.add(new int[]{num+B[B.length-1], B.length-1});
        }

        List<Integer> ans = new ArrayList<>();
        while(K > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int sum = pair[0];
            int pos = pair[1];
            ans.add(sum-B[pos]+B[pos]);
            if(pos-1 >= 0) {
                pq.add(new int[]{sum-B[pos]+B[pos-1], pos-1});
            }
            K--;
        }

        return ans;
    }

}
