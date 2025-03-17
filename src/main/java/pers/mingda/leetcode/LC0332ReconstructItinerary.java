package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0332ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> flightMap = buildFlightMap(tickets);
        Map<List<String>, Integer> ticketsCount = countTickets(tickets);
        return buildItinerary(flightMap, ticketsCount, "JFK", new ArrayList<>(), tickets.size() + 1);
    }

    private Map<String, List<String>> buildFlightMap(List<List<String>> tickets) {
        Map<String, List<String>> flightMap = new HashMap<>();
        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            List<String> dests = flightMap.computeIfAbsent(from, k -> new ArrayList<>());
            dests.add(to);
        }

        for (String airport: flightMap.keySet()) {
            Collections.sort(flightMap.get(airport));
        }

        return flightMap;
    }

    private Map<List<String>, Integer> countTickets(List<List<String>> tickets) {
        Map<List<String>, Integer> ticketsCount = new HashMap<>();
        for (List<String> ticket: tickets) {
            ticketsCount.merge(ticket, 1, Integer::sum);
        }
        return ticketsCount;
    }

    private List<String> buildItinerary(Map<String, List<String>> flightMap, Map<List<String>, Integer> ticketsCount, String from, List<String> itinerary, int total) {
        itinerary.add(from);
        if (itinerary.size() == total) {
            return itinerary;
        }

        if (!flightMap.containsKey(from)) {
            return List.of();
        }

        for (String to: flightMap.get(from)) {
            List<String> ticket = List.of(from, to);
            if (ticketsCount.getOrDefault(ticket, 0) == 0) {
                continue;
            }

            ticketsCount.merge(ticket, -1, Integer::sum);
            List<String> result = buildItinerary(flightMap, ticketsCount, to, itinerary, total);
            if (!result.isEmpty()) {
                return result;
            }
            ticketsCount.merge(ticket, 1, Integer::sum);
            itinerary.removeLast();
        }
        return List.of();
    }
}
