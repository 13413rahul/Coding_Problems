package com.company.prime.gfg;

import java.util.HashSet;
import java.util.Set;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-123/problems
public class FindBotsOnGeekLandster {
    public int[] findBots(String usernames[], int n){
        // Code Here.
        Set<Integer> primes = Set.of(2,3,5,7,11,13,17,19,23);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            Set<Character> set = new    HashSet<>();
            for(int j = 0; j < usernames[i].length(); j = j + 2) {
                set.add(usernames[i].charAt(j));
            }

            if(primes.contains(set.size())) {
                ans[i] = 1;
            }else {
                ans[i] = 0;
            }
        }

        return ans;
    }
}
