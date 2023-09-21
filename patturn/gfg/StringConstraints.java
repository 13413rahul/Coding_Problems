package com.company.patturn.gfg;

// https://practice.geeksforgeeks.org/contest/job-a-thon-22-hiring-challange/problems
public class StringConstraints {
    public int CountStrings(String s){
        // Code Here.
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int maxFreq = 0;
            int max = 0;
            int[] count = new int[11];
            for(int j = i; j < Math.min(i + 81, s.length()); j++) {
                max = Math.max(max, s.charAt(j) - '0');
                count[s.charAt(j) - '0']++;
                maxFreq = Math.max(maxFreq, count[s.charAt(j) - '0']);
                if(maxFreq < max) {
                    ans++;
                }
            }

        }

        return ans;
    }

}
