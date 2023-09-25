package com.company.stack.leetcode;

import java.util.ArrayList;
import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/description/
public class OnlineStockSpan {
    ArrayList<Integer> list;
    Stack<Integer> st;
    public OnlineStockSpan() {
        list = new ArrayList<Integer>();
        st = new Stack<>();
    }

    public int next(int price) {
        while(st.size() > 0 && list.get(st.peek()) <= price) {
            st.pop();
        }
        list.add(price);
        if(st.size() == 0){
            st.push(list.size()-1);
            return list.size();
        } else {
            int val = st.peek();
            st.push(list.size()-1);
            return list.size()-1 - val;
        }
    }
}
