package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class LC2392BuildAMatrixWithConditions {
}

class LC2392TopologySortSolution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

      List<Integer> sortedRow = topologySort(k, rowConditions);
      if (sortedRow.isEmpty()) {
        return new int[0][0];
      }
      List<Integer> sortedCol = topologySort(k, colConditions);
      if (sortedCol.isEmpty()) {
        return new int[0][0];
      }

      int[][] result = new int[k][k];
      for (int i = 0; i < k; i++) {
        for (int j = 0; j < k; j++) {
          if (Objects.equals(sortedRow.get(i), sortedCol.get(j))) {
            result[i][j] = sortedRow.get(i);
          }
        }
      }
      return result;
    }

    private List<Integer> topologySort(int k, int[][] conditions) {
      Map<Integer, Set<Integer>> adj = new HashMap<>();
      int[] indegree = new int[k + 1];
      for (int[] condition : conditions) {
        int first = condition[0];
        int next = condition[1];
        if (adj.computeIfAbsent(first, f -> new HashSet<>()).add(next)) {
          indegree[next]++;
        }
      }

      List<Integer> result = new ArrayList<>();
      Queue<Integer> nodes = new LinkedList<>();
      for (int i = 1; i < indegree.length; i++) {
        if (indegree[i] == 0) {
          nodes.add(i);
        }
      }

      while (!nodes.isEmpty()) {
        int node = nodes.remove();
        result.add(node);

        if (!adj.containsKey(node)) {
          continue;
        }

        for (int dependent : adj.get(node)) {
          indegree[dependent]--;
          if (indegree[dependent] == 0) {
            nodes.add(dependent);
          }
        }
      }

      return result.size() == k ? result : List.of();
    }
  }