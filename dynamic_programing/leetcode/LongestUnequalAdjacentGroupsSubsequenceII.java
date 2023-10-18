package com.company.dynamic_programing.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/description/
public class LongestUnequalAdjacentGroupsSubsequenceII {
    private boolean validHamming(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        boolean diff = false;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                if(diff) {
                    return false;
                }
                diff = true;
            }
        }
        return true;
    }
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[] max = new int[n];
        max[n-1] = 1;
        int maxSubseq = 1;

        for(int i = n-2; i >= 0; i--) {
            int maxDist = 1;
            for(int j = i+1; j < n; j++) {
                if(groups[i] != groups[j] && validHamming(words[i], words[j])) {
                    maxDist = Math.max(max[j]+1, maxDist);
                }
            }
            max[i] = maxDist;
            maxSubseq = Math.max(maxSubseq, maxDist);
        }
        List<String> ans = new ArrayList<>();
        int i = 0, last = -1;
        while(i < n) {
            while(max[i] != maxSubseq) {
                i++;
            }

            if(last == -1 || validHamming(ans.get(ans.size()-1), words[i]) && groups[last] != groups[i]) {
                ans.add(words[i]);
                last = i;
                maxSubseq--;
                if(maxSubseq == 0) {
                    break;
                }
            }

            i++;
        }
        return ans;
    }
}
