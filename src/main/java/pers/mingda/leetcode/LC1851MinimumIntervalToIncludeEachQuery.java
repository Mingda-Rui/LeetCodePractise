package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1851MinimumIntervalToIncludeEachQuery {

  public int[] minInterval(int[][] intervals, int[] queries) {
    Queue<int[]> pq = new PriorityQueue<>(
      (i1, i2) -> (i1[1] - i1[0]) - (i2[1] - i2[0])
    );
    int[] copied = Arrays.copyOf(queries, queries.length);
    Arrays.sort(copied);
    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    // query : smallestInterval
    Map<Integer, Integer> smallestQueries = new HashMap<>();
    int[] result = new int[queries.length];

    int intervalIndex = 0;
    for (int query : copied) {
      if (smallestQueries.containsKey(query)) {
        continue;
      }
      while (
        intervalIndex < intervals.length && intervals[intervalIndex][0] <= query
      ) {
        pq.add(intervals[intervalIndex]);
        intervalIndex++;
      }

      while (!pq.isEmpty() && pq.peek()[1] < query) {
        pq.remove();
      }

      int smallestInterval = pq.isEmpty() ? -1 : getSize(pq.peek());
      smallestQueries.put(query, smallestInterval);
    }

    return buildResult(queries, smallestQueries);
  }

  private int getSize(int[] interval) {
    return interval[1] - interval[0] + 1;
  }

  private int[] buildResult(int[] queries, Map<Integer, Integer> map) {
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int query = queries[i];
      result[i] = map.get(query);
    }
    return result;
  }
}
