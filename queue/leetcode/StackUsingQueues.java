package com.company.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/description/
public class StackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        for(int i = 1; i <= 3; i++) {
            stack.push(i);
            System.out.println(stack.top());
            System.out.println(stack.pop());
        }
    }
}

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        top = x;
    }

    public int pop() {
        while(q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        int v = q1.poll();

        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;

        return v;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.size() == 0;
    }
}
