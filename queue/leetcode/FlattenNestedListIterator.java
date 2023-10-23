package com.company.queue.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/flatten-nested-list-iterator/?envType=daily-question&envId=2023-10-20
public class FlattenNestedListIterator {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private List<Integer> flattened;
    private int index;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        flattened = new ArrayList<>();
        index = 0;
        flattened = flatten(nestedList);
    }

    private List<Integer> flatten(List<NestedInteger> nested) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger ni : nested) {
            if (ni.isInteger()) {
                result.add(ni.getInteger());
            } else {
                result.addAll(flatten(ni.getList()));
            }
        }
        return result;
    }

    public int next() {
        return flattened.get(index++);
    }

    public boolean hasNext() {
        return index < flattened.size();
    }

}
