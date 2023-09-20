package com.company.patturn.gfg;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-120/problems
public class IsItPossibleToSortTheArray {
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static boolean check(int D, int N, int[] A) {
        // code here
        int g=gcd(D,N);
        if(g>0){
            for(int i=0;i<g;i++){
                int[] tmp = new int[(N-i+g-1)/g];
                int j = 0;
                for(int k=i;k<N;k+=g){
                    tmp[j++] = A[k];
                }
                Arrays.sort(tmp);
                j=0;
                for(int k=i;k<N;k+=g){
                    A[k]=tmp[j++];
                }
            }
        }

        for(int i=0;i+1<N;i++){
            if(A[i]>A[i+1])
                return false;
        }
        return true;
    }
}
