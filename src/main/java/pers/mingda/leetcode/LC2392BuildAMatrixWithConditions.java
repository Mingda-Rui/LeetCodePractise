package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
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

        for (int dependent : adj.computeIfAbsent(node, a ->  new HashSet<>())) {
          indegree[dependent]--;
          if (indegree[dependent] == 0) {
            nodes.add(dependent);
          }
        }
      }

      return result.size() == k ? result : List.of();
    }
  }

class LC2392DfsSolution {
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
    Map<Integer, Set<Integer>> adjacent = new HashMap<>();
    for (int[] condition : conditions) {
      int first = condition[0];
      int next = condition[1];
      adjacent.computeIfAbsent(first, f -> new HashSet<>()).add(next);
    }

    List<Integer> result = new ArrayList<>();
    int[] visited = new int[k + 1];
    for (int i = 1; i <= k; i++) {
      if (visited[i] != 0) {
        continue;
      }
      if (detectLoopElseSort(adjacent, i, visited, result)) {
        return List.of();
      }
    }
    Collections.reverse(result);
    return result;
  }

  private boolean detectLoopElseSort(Map<Integer, Set<Integer>> adjacent, int node, int[] visited, List<Integer> result) {
    if (visited[node] == 1) {
      return true;
    }
    if (visited[node] == 2) {
      return false;
    }
    visited[node] = 1;
    for (int neighbour : adjacent.computeIfAbsent(node, a -> new HashSet<>())) {
      if (detectLoopElseSort(adjacent, neighbour, visited, result)) {
        return true;
      }
    }
    result.add(node);
    visited[node] = 2;
    return false;
  }
}