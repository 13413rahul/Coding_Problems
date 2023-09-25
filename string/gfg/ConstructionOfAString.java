package com.company.string.gfg;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-120-1628/problems
public class ConstructionOfAString {
    String construct(int N, int K)
    {
        // code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N / 2; i++) {
            sb.append("ab");
        }

        if(N % 2 != 0) {
            sb.append("a");
        }

        return sb.toString();
    }
}
