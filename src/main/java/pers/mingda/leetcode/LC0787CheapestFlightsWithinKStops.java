package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class LC0787CheapestFlightsWithinKStops {

  public int findCheapestPrice(
    int n,
    int[][] flights,
    int src,
    int dst,
    int k
  ) {
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

        for (List<Integer> flight : fromCityFlights.get(from)) {
          int to = flight.get(1);
          int toPrice = fromPrice + flight.get(2);
          if (
            !bestPriceToCity.containsKey(to) ||
            bestPriceToCity.get(to) > toPrice
          ) {
            queue.add(to);
            int tempPrice = tempMap.getOrDefault(to, toPrice);
            tempMap.put(to, Math.min(toPrice, tempPrice));
          }
        }
      }
      for (int city : tempMap.keySet()) {
        int newPrice = tempMap.get(city);
        bestPriceToCity.put(city, newPrice);
      }
    }

    return bestPriceToCity.getOrDefault(dst, -1);
  }

  private Map<Integer, Set<List<Integer>>> buildFlightMap(int[][] flights) {
    Map<Integer, Set<List<Integer>>> flightMap = new HashMap<>();
    for (int[] flight : flights) {
      int from = flight[0];
      flightMap
        .computeIfAbsent(from, k -> new HashSet<>())
        .add(Arrays.stream(flight).boxed().collect(Collectors.toList()));
    }
    return flightMap;
  }

  public int findCheapestPriceBellmanFord(
    int n,
    int[][] flights,
    int src,
    int dst,
    int k
  ) {
    Map<Integer, Integer> cheapestPrice = new HashMap<>();
    cheapestPrice.put(src, 0);
    boolean updated = false;
    while (k >= 0) {
      updated = false;
      Map<Integer, Integer> newCheapest = new HashMap<>(cheapestPrice);
      for (int[] flight : flights) {
        int city = flight[0];
        if (!cheapestPrice.containsKey(city)) {
          continue;
        }
        int next = flight[1];
        int nextPrice = cheapestPrice.get(city) + flight[2];
        if (
          !newCheapest.containsKey(next) || newCheapest.get(next) > nextPrice
        ) {
          updated = true;
          newCheapest.put(next, nextPrice);
        }
      }
      cheapestPrice = newCheapest;
      if (!updated) {
        return cheapestPrice.getOrDefault(dst, -1);
      }
      k--;
    }
    return cheapestPrice.getOrDefault(dst, -1);
  }

  public int findCheapestPriceDijkstra(
    int n,
    int[][] flights,
    int src,
    int dst,
    int k
  ) {
    Map<Integer, Set<List<Integer>>> flightMap = buildFlightMap(flights);
    Queue<List<Integer>> minHeap = new PriorityQueue<>(
      Comparator.comparingInt(f -> f.get(1))
    );
    // node, dist_from_src, number_of_stops_from_src
    minHeap.add(List.of(src, 0, -1));
    Map<Integer, Integer> stopCounter = new HashMap<>();

    while (!minHeap.isEmpty()) {
      List<Integer> current = minHeap.poll();
      int node = current.getFirst();
      int totalDistance = current.get(1);
      int stop = current.getLast();
      if (node == dst) {
        return current.get(1);
      }
      if (stop >= k) {
        continue;
      }
      if (stopCounter.containsKey(node) && stopCounter.get(node) <= stop) {
        continue;
      }

      stopCounter.put(node, stop);

      if (!flightMap.containsKey(node)) {
        continue;
      }

      for (List<Integer> flight : flightMap.get(node)) {
        int next = flight.get(1);
        int distance = flight.getLast();
        minHeap.add(List.of(next, totalDistance + distance, stop + 1));
      }
    }
    return -1;
  }
}
