package com.company.set.leetcode;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/?envType=daily-question&envId=2023-09-12
public class MinDeletionMakeFreqEquals {
    public static void main(String[] args) {
        String s = "aaabbbcc";

        Solution solution = new Solution();
        int minOp = solution.minDeletions(s);
        System.out.println(minOp);

    }

    static class Solution {
        public int minDeletions(String s) {
            HashMap<Character, Integer> cnt = new HashMap<>();
            int deletions = 0;
            HashSet<Integer> used_frequencies = new HashSet<>();

            for (char c : s.toCharArray()) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }

            for (int freq : cnt.values()) {
                while (freq > 0 && used_frequencies.contains(freq)) {
                    freq--;
                    deletions++;
                }
                used_frequencies.add(freq);
            }

            return deletions;
        }
    }
}
