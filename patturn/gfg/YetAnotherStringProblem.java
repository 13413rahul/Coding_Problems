package com.company.patturn.gfg;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/contest/job-a-thon-22-hiring-challange/problems
public class YetAnotherStringProblem {

    public int GetMax(int n, int k, String s[]){
        Map<Integer, Integer> hm = new HashMap<>();
        for(String x : s){
            int mask = mask(x);
            hm.put(mask, hm.getOrDefault(mask, 0) + 1);
        }

        int max = 0;
        for(int x = 1; x <= (1 << 10); x++){
            if(Integer.bitCount(x) != k)
                continue;
            int mask = 0, count = 0;
            for(Map.Entry<Integer, Integer> e : hm.entrySet()){
                if((e.getKey() | x) == x){
                    mask |= e.getKey();
                    count += e.getValue();
                }
            }

            max = (mask == x && count > max) ? count : max;
        }

        return max;
    }

    private int mask(String s){
        int mask = 0;
        for(char c : s.toCharArray()){
            mask |= (1 << (int)(c - 'a'));
        }
        return mask;
    }

}
