package com.company.recursion.leetcode;

// https://leetcode.com/problems/power-of-four/description/?envType=daily-question&envId=2023-10-23
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        // Iterate through powers of 4 from 4^0 to 4^15
        for (int i = 0; i <= 15; i++) {
            int powerOfFour = (int) Math.pow(4, i);

            // If we find a power of four equal to 'n', return true
            if (powerOfFour == n)
                return true;

            // If the current power of four is greater than 'n', there's no need to continue
            if (powerOfFour > n)
                return false;
        }

        // 'n' is not a power of four
        return false;
    }
}
