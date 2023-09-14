package com.company.codeforce;

import java.util.Scanner;

// https://codeforces.com/contest/1869/problem/A
public class MakeItZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if ((n & 1) == 1) {
                System.out.println(4);
                System.out.println("1 " + (n - 1));
                System.out.println("1 " + (n - 1));
                System.out.println((n - 1) + " " + n);
                System.out.println((n - 1) + " " + n);
            } else {
                System.out.println(2);
                System.out.println("1 " + n);
                System.out.println("1 " + n);
            }

        }
    }
}