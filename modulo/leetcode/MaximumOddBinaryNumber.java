package com.company.modulo.leetcode;

// https://leetcode.com/contest/weekly-contest-364/problems/maximum-odd-binary-number/
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder ans = new StringBuilder();
        int ct = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') {
                ct++;
            }
        }

        for(int i = 0; i < ct - 1; i++) {
            ans.append("1");
        }

        for(int i = 0; i < s.length() - ct; i++) {
            ans.append("0");
        }

        ans.append("1");

        return ans.toString();
    }
}
