package com.company.stack.gfg;

import java.util.Stack;

// https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-120/problems
public class EmptyTheString {
    static int makeStringEmpty(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int count = 0;
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) != 'k') {
                stack.push(s.charAt(i));
                i++;
            }

            if(i >= s.length()) {
                return -1;
            }

            if(stack.isEmpty() || stack.peek() != 'e') {
                return -1;
            }
            stack.pop();

            if(stack.isEmpty() || stack.peek() != 'e') {
                return -1;
            }
            stack.pop();

            if(stack.isEmpty() || stack.peek() != 'g') {
                return -1;
            }
            stack.pop();

            count++;
            i++;

        }

        if(!stack.isEmpty()) {
            return -1;
        }

        return count;
    }

}
