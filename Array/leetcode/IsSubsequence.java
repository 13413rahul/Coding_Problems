package com.company.Array.leetcode;

// https://leetcode.com/problems/is-subsequence/description/?envType=daily-question&envId=2023-09-22
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
