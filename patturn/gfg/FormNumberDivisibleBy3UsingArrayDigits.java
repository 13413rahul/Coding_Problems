package com.company.patturn.gfg;

// https://practice.geeksforgeeks.org/problems/form-a-number-divisible-by-3-using-array-digits0717/1
public class FormNumberDivisibleBy3UsingArrayDigits {
    static int isPossible(int N, int arr[]) {
        // code here
        long count = 0;
        for(int i=0;i<N;i++) {
            count+=arr[i];
        }
        int div= count%3==0?1:0;
        return div;
    }
}
