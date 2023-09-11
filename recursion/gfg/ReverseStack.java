package com.company.recursion.gfg;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/reverse-a-stack/1
public class ReverseStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
//        for(int i = 0; i < size; i++) {
//            int val = sc.nextInt();
//            stack.push(val);
//        }

        stack.addAll(List.of(3,2,1,7,6));
        Solution solution = new Solution();
        solution.reverse(stack);

        System.out.println(stack);
    }
}

class Solution
{
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty()) {
            return;
        }

        int t = s.pop();
        reverse(s);
        insert(s, t);
    }

    static void insert(Stack<Integer> s, int k) {
        if(s.isEmpty()) {
            s.push(k);
            return;
        }

        int t = s.pop();
        insert(s, k);
        s.push(t);
    }
}
