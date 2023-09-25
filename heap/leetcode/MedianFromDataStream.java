package com.company.heap.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/description/
public class MedianFromDataStream {

    /** initialize your data structure here. */
    // 2n + 1 numbers

    // n median n
    // n - 1 median 1, median 2 n - 1
    // min heap to record larger half of the array
    // max heap to record smaller half of the array
    // median can be found in O(1) time
    // if new number >= top of the max heap : goes to min heap
    // else goes to min heap
    // rebalancing until size(max) - size(min) <= 1
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    public MedianFromDataStream() {
        // lower portion of the number
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // upper portion of the number
        minHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            // make sure maxheap.size() >= minheap.size()
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }
        else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0) {
            throw new IllegalArgumentException("no number");
        }
        if (maxHeap.size() != minHeap.size()) {
            return maxHeap.peek() + 0.0;
        }
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
