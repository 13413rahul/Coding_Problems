package com.company.greedy.leetcode;

// https://leetcode.com/problems/integer-break/description/?envType=daily-question&envId=2023-10-06
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }
}
