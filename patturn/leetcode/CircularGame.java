package com.company.patturn.leetcode;

import java.util.Scanner;

public class CircularGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfPeople = sc.nextInt();
        int positionOfKill = sc.nextInt();

        Solution solution = new Solution();
        int leftPeople = solution.findTheWinner(noOfPeople, positionOfKill);

        System.out.println(leftPeople);
    }
}

class Solution {

    public int helper(int n, int k){
        if(n==1) {
            return 0;
        }

        return (helper(n-1, k) + k) % n;
    }

    public int findTheWinner(int n, int k) {
        return helper(n, k) + 1;   //+1 is for converting 0-based indexing to 1-based indexing
    }
}
