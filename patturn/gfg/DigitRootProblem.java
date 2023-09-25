package com.company.patturn.gfg;

// https://practice.geeksforgeeks.org/problems/repetitive-addition-of-digits2221/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class DigitRootProblem {
    static int digSum1(int n)
    {
        int sum = 0;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    static int digSum2(int n)
    {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }

    // Driver program to test the above function
    public static void main (String[] args)
    {
        int n = 9999;
        System.out.println(digSum1(n));
    }
}
