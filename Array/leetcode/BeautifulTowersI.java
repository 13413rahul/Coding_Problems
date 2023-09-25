package com.company.Array.leetcode;

import java.util.List;

// https://leetcode.com/problems/beautiful-towers-i/submissions/1057542040/
public class BeautifulTowersI {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = 0;
        int s = maxHeights.size();
        for(int i = 0; i < s; i++) {
            long sum = maxHeights.get(i);
            int j = i - 1;
            int prev = maxHeights.get(i);
            while(j >= 0) {
                if(maxHeights.get(j) > prev) {
                    sum += prev;
                }else {
                    prev = maxHeights.get(j);
                    sum += maxHeights.get(j);
                }
                j--;
            }

            j = i + 1;
            prev = maxHeights.get(i);
            while(j < s) {
                if(maxHeights.get(j) > prev) {
                    sum += prev;
                }else {
                    prev = maxHeights.get(j);
                    sum += maxHeights.get(j);
                }
                j++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
