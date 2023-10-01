package com.company.string.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-122/problems
public class SameCharacter {
    public int solve(String S, int n) {
        // code here
        int[] count = new int[26];
        for(char c : S.toCharArray()) {
            count[c - 'a']++;
        }

        int ans = 0;
        for(int v : count) {
            if(v > 0) {
                ans++;
            }
        }

        return ans - 1;
    }
}
