package com.company.string.leetcode;

// https://leetcode.com/problems/find-the-difference/description/?envType=daily-question&envId=2023-09-25
public class FindDifference {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            result ^= t.charAt(i);
        }
        return result;
    }
}
