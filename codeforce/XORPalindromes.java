package com.company.codeforce;

import java.util.*;

// https://codeforces.com/contest/1867/problem/B
public class XORPalindromes{
    public static void main(String args[]){
        Scanner ps = new Scanner(System.in);
        int T = ps.nextInt();
        for(int x =0;x<T;x++){
            int n = ps.nextInt();
            String s = ps.next();

            char[] arr = new char[n + 1];
            Arrays.fill(arr, '0');
            int m = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) {
                    m++;
                }
            }
            if (n % 2 == 1) {
                m /= 2;
                int c = n / 2 - m;
                for (int i = 0; i <= c; i++) {
                    arr[m + 2 * i] = '1';
                    arr[m + 2 * i + 1] = '1';
                }
            } else {
                m /= 2;
                int c = (n + 1) / 2 - m;
                for (int i = 0; i <= c; i++) {
                    arr[m + 2 * i] = '1';
                }
            }
            System.out.println(new String(arr));

        }
    }
}
