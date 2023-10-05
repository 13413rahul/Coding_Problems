package com.company.hashmap.gfg;

import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1
public class RomanNumberToInteger {
    // User function Template for Java

    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        HashMap<Character, Integer> h=new HashMap<>();

        int n=str.length();

        h.put('I', 1);
        h.put('V', 5);
        h.put('X', 10);
        h.put('L', 50);
        h.put('C', 100);
        h.put('D', 500);
        h.put('M', 1000);

        int sum=0;
        for(int i=0;i<n-1;i++){
            if(h.get(str.charAt(i)) < h.get(str.charAt(i+1)))
                sum-=h.get(str.charAt(i));
            else
                sum+=h.get(str.charAt(i));
        }

        sum+=h.get(str.charAt(n-1));

        return sum;
    }

}
