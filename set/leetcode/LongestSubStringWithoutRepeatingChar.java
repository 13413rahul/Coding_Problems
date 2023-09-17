package com.company.set.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubStringWithoutRepeatingChar {
    static int solve(String str) {

        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        Set< Character > set = new HashSet< >();
        int l = 0;
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found
            {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }

    public static void main(String args[]) {
        String str = "mynameiskhan";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));

    }
}
