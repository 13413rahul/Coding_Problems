package com.company.hashmap.leetcode;

import java.util.*;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/?envType=daily-question&envId=2023-09-11
public class GroupPeople {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();

        // [3,3,3,3,3,1,3]
//        int[] groupSizes = new int[size];
//        for(int i = 0; i < size; i++) {
//            groupSizes[i] = sc.nextInt();
//        }

        int[] groupSizes = {3,3,3,3,3,1,3};
        Solution solution = new Solution();
        List<List<Integer>> groupedPeople = solution.groupThePeople(groupSizes);

        System.out.println(groupedPeople);

    }

    static class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> ans = new ArrayList<>();

            // A map from group size to the list of indices that are there in the group.
            Map<Integer, List<Integer>> szToGroup = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                if (!szToGroup.containsKey(groupSizes[i])) {
                    szToGroup.put(groupSizes[i], new ArrayList<>());
                }

                List<Integer> group = szToGroup.get(groupSizes[i]);
                group.add(i);

                // When the list size equals the group size, empty it and store it in the answer.
                if (group.size() == groupSizes[i]) {
                    ans.add(group);
                    szToGroup.remove(groupSizes[i]);
                }
            }

            return ans;
        }
    }
}


