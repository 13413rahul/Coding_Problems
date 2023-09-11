package com.company.patturn.gfg;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1
public class LuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();

        // number = 100
        Solution solution = new Solution();
        boolean numberIsLucky = solution.isLucky(1000);

        System.out.println(numberIsLucky);

    }
}

class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        return isLucky(n, 2);
    }

    static boolean isLucky(int n, int count) {
        if(n < count) {
            return true;
        }

        if(n % count == 0) {
            return false;
        }

        return isLucky(n - n / count, count + 1);
    }
}


