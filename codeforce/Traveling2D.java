package com.company.codeforce;

import java.io.BufferedInputStream;
import java.util.Scanner;

// https://codeforces.com/contest/1869/problem/B
public class Traveling2D {
    static class Node {
        long x;
        long y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long k = in.nextLong() - 1;
            int s = in.nextInt() - 1;
            int e = in.nextInt() - 1;
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(in.nextLong(), in.nextLong());
            }


            long res = Math.abs(nodes[s].x - nodes[e].x) + Math.abs(nodes[s].y - nodes[e].y);
            long mina = (long) 1e16;
            long minb = (long) 1e16;

            for (int i = 0; i <= k; i++) {
                mina = Math.min(mina, Math.abs(nodes[s].x - nodes[i].x) + Math.abs(nodes[s].y - nodes[i].y));
                minb = Math.min(minb, Math.abs(nodes[e].x - nodes[i].x) + Math.abs(nodes[e].y - nodes[i].y));
            }
            System.out.println(Math.min(res, minb + mina));

        }
    }

}
