package com.company.heap.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class KthLargestElementInStream {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k=k;
        for(int num : nums)
            heap.offer(num);
    }

    public int add(int val) {
        heap.offer(val);
        while(heap.size()>k)
            heap.poll();
        return heap.peek();
    }
}
