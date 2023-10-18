package com.company.Array.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
public class LongestUnequalAdjacentGroupsSubsequenceI {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        return getHelp(words, groups);
    }

    List<String> getHelp(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        for(int j = 0; j < words.length; j++) {

            while(j + 1 < words.length && groups[j] == groups[j + 1]) {
                j++;
            }
            list.add(words[j]);
        }

        return list;
    }
}
