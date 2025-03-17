package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0332ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> flightMap = buildFlightMap(tickets);
        return buildItinerary(flightMap, new ArrayList<>(), "JFK");
    }

    private Map<String, Queue<String>> buildFlightMap(List<List<String>> tickets) {
        Map<String, Queue<String>> flightMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.getFirst();
            String to = ticket.getLast();
            flightMap.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }
        return flightMap;
    }

    private List<String> buildItinerary(Map<String, Queue<String>> flightMap, List<String> itinerary, String airport) {
        if (!flightMap.containsKey(airport)) {
            itinerary.addFirst(airport);
            return itinerary;
        }
        Queue<String> destinations = flightMap.get(airport);
        while (!destinations.isEmpty()) {
            buildItinerary(flightMap, itinerary, flightMap.get(airport).poll());
        }
        itinerary.addFirst(airport);
        return itinerary;
    }
}
