package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1094CarPooling {}

class LC1094DoublePriorityQueueSolution {

  public boolean carPooling(int[][] trips, int capacity) {
    Queue<Integer> fromQueue = new PriorityQueue<>(Comparator.comparingInt(i -> trips[i][1]));
    Queue<Integer> toQueue = new PriorityQueue<>(Comparator.comparingInt(i -> trips[i][2]));
    for (int i = 0; i < trips.length; i++) {
      fromQueue.add(i);
      toQueue.add(i);
    }

    int totalPassengers = 0;
    int location = 0;
    while (!fromQueue.isEmpty() || !toQueue.isEmpty()) {
      if (!fromQueue.isEmpty()) {
        int t = fromQueue.remove();
        totalPassengers += trips[t][0];
        location = trips[t][1];
      }

      while (
        !toQueue.isEmpty() &&
        (trips[toQueue.peek()][2] <= location ||
          (fromQueue.isEmpty() && totalPassengers <= capacity))
      ) {
        int t = toQueue.remove();
        totalPassengers -= trips[t][0];
      }

      if (totalPassengers > capacity) {
        return false;
      }
    }
    return true;
  }
}
