package com.company.graph.leetcode;

import java.util.*;

// https://leetcode.com/problems/reconstruct-itinerary/description/?envType=daily-question&envId=2023-09-14
public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = List.of(List.of("MUC","LHR"),List.of("JFK","MUC"),List.of("SFO","SJC"),List.of("LHR","SFO"));

        Solution solution = new Solution();
        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary);
    }

    static class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, PriorityQueue<String>> graph = new HashMap<>();

            for (List<String> ticket : tickets) {
                graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                graph.get(ticket.get(0)).add(ticket.get(1));
            }

            LinkedList<String> itinerary = new LinkedList<>();

            dfs("JFK", graph, itinerary);

            return itinerary;
        }

        private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
            PriorityQueue<String> nextAirports = graph.get(airport);
            while (nextAirports != null && !nextAirports.isEmpty()) {
                dfs(nextAirports.poll(), graph, itinerary);
            }
            itinerary.addFirst(airport);
        }
    }
}
