package com.company.hashmap.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/description/?envType=daily-question&envId=2023-10-04
public class DesignHashMap {

    private static final int SIZE = 1000;
    private List<int[]>[] map;

    public DesignHashMap() {
        map = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        List<int[]> bucket = map[index];
        for (int[] pair : bucket) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        bucket.add(new int[]{key, value});
    }

    public int get(int key) {
        int index = key % SIZE;
        List<int[]> bucket = map[index];
        for (int[] pair : bucket) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;
        List<int[]> bucket = map[index];
        for (int i = 0; i < bucket.size(); i++) {
            int[] pair = bucket.get(i);
            if (pair[0] == key) {
                bucket.remove(i);
                return;
            }
        }
    }

}
