package com.company.codeforce;

import java.io.*;
import java.util.*;

// https://codeforces.com/contest/1867/problem/C
public class Salyg1NandTheMEXGame {
    void go() {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) a[i] = nextInt();
        if (a[0] != 0) {
            sl(0);
            int r = nextInt();
            if (r == -1 || r == -2) return;
            throw new RuntimeException("0 is no.");
        }
        int last = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] == i) {
                last = i;
            } else break;
        }
        sl(last + 1);
        while (true) {
            int r = nextInt();
            if (r < 0) return;
            sl(r);
        }
    }


    boolean MULTI_CASE = true;
    boolean ALWAYS_FLUSH = true;


    /**
     * Input.
     */
    InputStream inStream;
    byte[] inBuff = new byte[1024];
    int inBuffCursor = 0, inBuffLen = 0;

    boolean isVisibleChar(int c) {
        return 33 <= c && c <= 126;
    }

    boolean hasNextByte() {
        if (inBuffCursor < inBuffLen) return true;
        inBuffCursor = 0;
        try {
            inBuffLen = inStream.read(inBuff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inBuffLen > 0;
    }

    boolean hasNext() {
        while (hasNextByte() && !isVisibleChar(inBuff[inBuffCursor])) inBuffCursor++;
        return hasNextByte();
    }

    int nextByte() {
        return hasNextByte() ? inBuff[inBuffCursor++] : -1;
    }

    String next() {
        if (!hasNext()) throw new RuntimeException("no next.");
        StringBuilder sb = new StringBuilder();
        int b = nextByte();
        while (isVisibleChar(b)) {
            sb.appendCodePoint(b);
            b = nextByte();
        }
        return sb.toString();
    }

    long nextLong() {
        if (!hasNext()) throw new RuntimeException("no next.");
        long result = 0;
        boolean negative = false;
        int b = nextByte();
        if (b < '0') {
            if (b == '-') negative = true;
            else if (b != '+') throw new RuntimeException("long number must start with +/-.");
            b = nextByte();
        }
        while (isVisibleChar(b)) {
            if (b < '0' || b > '9') throw new RuntimeException("wrong digit in long:" + (char) b);
            // TODO: may overflow here, even if it is a valid Long, eg.-(1<<63).
            result = result * 10 + (b - '0');
            b = nextByte();
        }
        return negative ? -result : result;
    }

    int nextInt() {
        long x = nextLong();
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE)
            throw new RuntimeException("int overflow:" + x);
        return (int) x;
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    /**
     * Output.
     */
    PrintWriter printOut = new PrintWriter(System.out);

    void so(Object obj, boolean newLine) {
        if (newLine) printOut.println(obj);
        else printOut.print(obj);
        if (ALWAYS_FLUSH) printOut.flush();
    }

    void so(Object obj) {
        so(obj, false);
    }

    void sl(Object obj) {
        so(obj, true);
    }

    void sl() {
        sl("");
    }

    /**
     * Main.
     */
    void mainGo() {
        try {
            inStream = new FileInputStream("src/main.in");
            ALWAYS_FLUSH = true;
        } catch (Exception e) {
            inStream = System.in;
        }
        while (hasNext()) {
            if (MULTI_CASE) {
                int T = nextInt();
                if (T == 0) break;
                for (int i = 0; i < T; ++i) {
                    go();
                }
            } else {
                go();
            }
        }
        printOut.flush();
    }

    public static void main(String[] args) throws Exception {
        new Salyg1NandTheMEXGame().mainGo();
    }
}

