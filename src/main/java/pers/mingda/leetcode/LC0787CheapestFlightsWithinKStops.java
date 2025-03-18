package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC0787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<List<Integer>>> fromCityFlights = buildFlightMap(flights);
        Map<Integer, Integer> bestPriceToCity = new HashMap<>();
        bestPriceToCity.put(src, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        for (int i = 0; i < k + 1; i++) {
            int size = queue.size();
            Map<Integer, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (queue.isEmpty()) {
                    return bestPriceToCity.getOrDefault(dst, -1);
                }
                int from = queue.poll();
                int fromPrice = bestPriceToCity.get(from);
                if (!fromCityFlights.containsKey(from)) {
                    continue;
                }

                for (List<Integer> flight: fromCityFlights.get(from)) {
                    int to = flight.get(1);
                    int toPrice = fromPrice + flight.get(2);
                    if (!bestPriceToCity.containsKey(to) || bestPriceToCity.get(to) > toPrice) {
                        queue.add(to);
                        int tempPrice = tempMap.getOrDefault(to, toPrice);
                        tempMap.put(to, Math.min(toPrice, tempPrice));
                    }
                }
            }
            for (int city: tempMap.keySet()) {
                int newPrice = tempMap.get(city);
                bestPriceToCity.put(city, newPrice);
            }
        }

        return bestPriceToCity.getOrDefault(dst, -1);
    }

    private Map<Integer, Set<List<Integer>>> buildFlightMap(int[][] flights) {
        Map<Integer, Set<List<Integer>>> flightMap = new HashMap<>();
        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            flightMap.computeIfAbsent(from, k -> new HashSet<>()).add(List.of(from, to, price));
        }
        return flightMap;
    }
}
