package com.company.modulo.gfg;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/rotate-bits4524/1
public class RotateBits {
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
        ArrayList<Integer> ans=new ArrayList<>();
        D%=16;
        ans.add(((N << D) | (N >> (16 - D))) & 65535);
        ans.add(((N >> D) | (N << (16 - D))) & 65535);
        return ans;

    }
}
