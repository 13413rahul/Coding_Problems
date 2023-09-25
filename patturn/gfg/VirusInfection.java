package com.company.patturn.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-120-1628/problems
public class VirusInfection {
    int solve(String s, int k)
    {
        // code here
        int[] arr = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                int left = Math.max(0, i - k);
                int right = Math.min(s.length(), i + k + 1);
                arr[left] += 1;
                arr[right] += -1;
            }
        }

        // System.out.println(Arrays.toString(arr));
        for(int i = 1; i < s.length() + 1; i++) {
            arr[i] += arr[i - 1];
        }

        int count = 0;
        for(int v : arr) {
            if(v > 0) {
                count++;
            }
        }

        return count;
    }
}
