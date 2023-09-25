package com.company.Array.gfg;

// https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
public class EquilibriumPoint {
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        long rightSum=0,leftSum=0;
        for(int i=0; i<n; i++) rightSum += arr[i];
        for(int i=0; i<n; i++){
            rightSum -= arr[i];
            if(leftSum == rightSum) return i+1;
            leftSum += arr[i];
        }
        return -1;
    }
}
