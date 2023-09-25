package com.company.greedy.gfg;

import java.util.Arrays;
import java.util.Comparator;

// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
public class FractionalKnapsack {

    static class Item {
        int value, weight;
        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    static class itemComparator implements Comparator<Item>
    {
        @Override
        public int compare(Item a, Item b)
        {
            double r1 = (double)(a.value) / (double)(a.weight);
            double r2 = (double)(b.value) / (double)(b.weight);
            if(r1 < r2) return 1;
            else if(r1 > r2) return -1;
            else return 0;
        }
    }


    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());

        int curWeight = 0;
        double finalvalue = 0.0;

        for (int i = 0; i < n; i++) {

            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }

            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }

        return finalvalue;

    }

    public static void main(String args[])
    {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }

}