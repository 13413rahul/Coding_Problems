package com.company.modulo.gfg;

// https://practice.geeksforgeeks.org/problems/find-first-set-bit-1587115620/1
public class FirstSetBit {
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){

        int count = 0;
        while(n >= 1) {
            count++;
            if(n % 2 != 0) {
                break;
            }
            n /= 2;
        }

        return count;

    }
}
