package com.company.stack.leetcode;

import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/beautiful-towers-ii/description/
public class BeautifulTowersII {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Stack<Integer> st = new Stack<>();
        int n = maxHeights.size();
        long[] pre = new long[n];
        int j = 0;
        while(j < n) {
            while(!st.isEmpty() && maxHeights.get(st.peek()) > maxHeights.get(j)) {
                st.pop();
            }
            if(st.isEmpty()) {
                pre[j] = 1l * j * maxHeights.get(j);
            }else {
                pre[j] = 1l * (j - st.peek() - 1) * maxHeights.get(j) + pre[st.peek()] + maxHeights.get(st.peek());
            }

            st.push(j);
            j++;
        }
        st.clear();
        // System.out.println(Arrays.toString(pre));

        long[] suff = new long[n];
        j = n - 1;
        while(j >= 0) {
            while(!st.isEmpty() && maxHeights.get(st.peek()) > maxHeights.get(j)) {
                st.pop();
            }
            if(st.isEmpty()) {
                suff[j] = 1l * (n - j - 1) * maxHeights.get(j);
            }else {
                suff[j] = 1l * (st.peek() - j - 1) * maxHeights.get(j) + suff[st.peek()] + maxHeights.get(st.peek());
            }

            st.push(j);
            j--;
        }

        // System.out.println(Arrays.toString(suff));

        long max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, pre[i] + suff[i] + maxHeights.get(i));
        }

        return max;

    }
}
