package com.company.dynamic_programing.leetcode;

import java.util.*;

// https://leetcode.com/problems/word-break/description/
public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");

        Solution solution = new Solution();
        boolean isBreakable = solution.wordBreak(s, wordDict);
        System.out.println(isBreakable);
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dic = new HashSet<>();
            for(String t : wordDict) {
                dic.add(t);
            }

            Map<String, Boolean> map = new HashMap<>();
            return dfs(0, 0, s, dic, map);
        }

        boolean dfs(int s, int e, String str, Set<String> dic, Map<String, Boolean> map) {
            if(e == str.length()) {
                return true;
            }

            if(map.containsKey(str.substring(e))) {
                return map.get(str.substring(e));
            }

            for(int i = s; i < str.length(); i++) {
                String t = str.substring(s, i + 1);
                // System.out.println(t);
                if(dic.contains(t)) {
                    if(dfs(i + 1, i + 1, str, dic, map)) {
                        map.put(str.substring(e), true);
                        return true;
                    }
                }
            }

            map.put(str.substring(e), false);
            return false;
        }
    }
}
