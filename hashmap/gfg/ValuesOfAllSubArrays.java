package com.company.hashmap.gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://practice.geeksforgeeks.org/contest/job-a-thon-hiring-challenge-experienced-professionals/problems
public class ValuesOfAllSubArrays {
    final static int MOD = 1000000000 + 7;
    public static int ValueOfSubarrays(int N, int[] arr) {
        // code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }


        long ans = 0;

        for(int k : map.keySet()) {
            List<Integer> l = map.get(k);
            long prev = -1;
            for(int i = 0; i < l.size() - 1; i++) {
                ans = (ans + 1l * (l.get(i) - prev) * (N - l.get(i + 1))) % MOD;
                prev = l.get(i);
            }
        }

        return (int)ans;

    }
}
