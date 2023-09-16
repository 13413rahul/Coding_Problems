package com.company.hashmap.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-array-length-after-pair-removals/description/
public class MinLengthAfterPairRemoval {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int key : m.keySet()) {
            heap.offer(new int[]{key, m.get(key)});
        }

        while(heap.size() > 1) {
            int[] a = heap.poll();
            int[] b = heap.poll();

            if(a[1] != 1)
                heap.offer(new int[]{a[0], a[1] - 1});

            if(b[1] != 1)
                heap.offer(new int[]{b[0], b[1] - 1});
        }

        return heap.isEmpty() ? 0 : heap.poll()[1];

    }
}
