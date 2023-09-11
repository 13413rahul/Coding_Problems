package com.company.sliding_window.leetcode;

import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum/
public class MaxInAllWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int size = sc.nextInt();
//        List<Integer> nums = new ArrayList<>();
//        for(int i = 0; i < size; i++) {
//            int ele = sc.nextInt();
//            nums.add(ele);
//        }
//        int windowSize = sc.nextInt();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int windowLength = 3;

        Solution solution = new Solution();
        int[] maxMaxInAllWindow = solution.maxSlidingWindow(nums, windowLength);

        System.out.println(Arrays.toString(maxMaxInAllWindow));
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        // Return the result as an array.
        return res.stream().mapToInt(i->i).toArray();
    }
}
