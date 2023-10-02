package com.company.string.gfg;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
public class NumberOfDistinctSubsequences {
    int distinctSubsequences(String s) {
        // code here
        long dp[] = new long[s.length()+1];
        dp[0]=1;
        int mod=(int)(1e9+7);
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=(2*dp[i-1]%mod)%mod;
            char ch=s.charAt(i-1);
            if(hm.containsKey(ch))
            {
                int val=hm.get(ch);
                dp[i]=(dp[i]%mod-dp[val-1]+mod)%mod;
            }

            hm.put(ch,i);

        }

        return (int)dp[s.length()]%mod;

    }
}
