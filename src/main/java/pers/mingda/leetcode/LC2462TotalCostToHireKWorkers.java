package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC2462TotalCostToHireKWorkers {
  public long totalCost(int[] costs, int k, int candidates) {
    long cost = 0;
    Queue<Integer> firstCandidates = new PriorityQueue<>();
    Queue<Integer> lastCandidates = new PriorityQueue<>();
    int firstIndex = 0;
    int lastIndex = costs.length - 1;
    for (int i = 0; i < k; i++) {
      while (firstCandidates.size() < candidates && firstIndex <= lastIndex) {
        firstCandidates.offer(costs[firstIndex]);
        firstIndex++;
      }
      while (lastCandidates.size() < candidates && firstIndex <= lastIndex) {
        lastCandidates.offer(costs[lastIndex]);
        lastIndex--;
      }

      if (!firstCandidates.isEmpty()
          && (lastCandidates.isEmpty() || firstCandidates.peek() <= lastCandidates.peek())) {
        cost += firstCandidates.poll();
      } else if (!lastCandidates.isEmpty()) {
        cost += lastCandidates.poll();
      }
    }
    return cost;
  }
}
