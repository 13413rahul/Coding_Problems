package com.company.Array.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/last-visited-integers/description/
public class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<String> l = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;

        for(String word : words) {
            if(word.equals("prev")) {
                count++;
                if(count > l.size()) {
                    ans.add(-1);
                }else {
                    ans.add(Integer.parseInt(l.get(l.size() - 1 - count + 1)));
                }
            }else {
                count = 0;
                l.add(word);
            }
        }

        return ans;
    }
}
