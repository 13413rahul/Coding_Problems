package com.company.recursion.gfg;

// https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
public class PowerOf2 {
    // Function to check if given number n is a power of two.
    public static boolean isPowerOfTwo(long n){
        return (countBit(n) == 1);
    }

    static int countBit(long n) {
        if(n <= 1) {
            return (int)n;
        }

        return (int)(n % 2) + countBit(n / 2);
    }
}
