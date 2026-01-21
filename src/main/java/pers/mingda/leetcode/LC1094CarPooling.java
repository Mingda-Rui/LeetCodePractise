package pers.mingda.leetcode;

import java.util.TreeMap;

public class LC1094CarPooling {}

class LC1094TreeMapQueueSolution {

  public boolean carPooling(int[][] trips, int capacity) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int[] trip : trips) {
      int passengers = trip[0];
      int from = trip[1];
      map.merge(from, passengers, Integer::sum);

      int to = trip[2];
      map.merge(to, -passengers, Integer::sum);
    }

    int passengerCount = 0;
    for (int p : map.values()) {
      passengerCount += p;
      if (passengerCount > capacity) {
        return false;
      }
    }
    return true;
  }
}
