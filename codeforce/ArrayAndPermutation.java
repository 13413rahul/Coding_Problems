package com.company.codeforce;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// https://codeforces.com/contest/1867/problem/A
public class ArrayAndPermutation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Pair[] arr = new Pair[n];

            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(sc.nextInt(), i);
            }

            ArrayOfPairsSorter.sort(arr);
//            System.out.println(arr);

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[arr[i].y] = n - i;
            }

            for (int e : ans) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    static class ArrayOfPairsSorter {
        static void sort(Pair[] arr) {
            Comparator<Pair> comparator = Comparator.comparingInt(p -> p.x);
            Arrays.sort(arr, comparator);
        }
    }

    static class Pair {
        int x;
        int y;

        // Constructor
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Overriding toString method
        //       for beautiful printing of pairs
        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
        }
    }


}
