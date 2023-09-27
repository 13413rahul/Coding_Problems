package com.company.string.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/repeated-string-match/description/
public class RepeatedStringMatchUsingKMP {
    public int repeatedStringMatch(String a, String b) {
        Set<Character> set = new HashSet<>();
        for(char c: a.toCharArray())
            set.add(c);
        for(char c: b.toCharArray())
            if(!set.contains(c)) return -1;

        int count = 1;
        String newA = a;
        while(newA.length() < b.length()){
            newA += a;
            count++;
        }

        // b substring (pattern) exist in newA
        if(matchPattern(newA, b)) return count;
        else if(matchPattern(newA+""+a, b)) return count+1;
        return -1;
    }
    //Finding b substring in a
    private boolean matchPattern(String a, String b){
        // if(rabinKarp(a, b)) return true;
        if(KMP(a, b)) return true;
        return false;
    }


    private boolean KMP(String string, String pattern){
        if(string.length() < pattern.length()) return false;
        int[] lps = new int[pattern.length()];
        fillLPS(pattern, lps);
        int i = 0, j = 0;

        while(i<string.length()){
            if(string.charAt(i) == pattern.charAt(j)){
                i++;j++;
            }
            if(j == pattern.length()){
                j = lps[pattern.length()-1];
                return true;
            }else if(i < string.length() && string.charAt(i) != pattern.charAt(j)){
                if(j == 0) i++;
                else j = lps[j - 1];
            }
        }
        return false;
    }

    private void fillLPS(String s, int[] lps){
        lps[0] = 0;
        int j = 0, i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else{
                if(j == 0){
                    lps[i] = 0;
                    i++;
                }else j = lps[j - 1];
            }
        }
    }
}
