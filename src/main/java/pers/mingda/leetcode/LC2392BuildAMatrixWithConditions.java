package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC2392BuildAMatrixWithConditions {
}

class LC2392TopologySortSolution {
  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

    int[] sortedRow = topologySort(k, rowConditions);
    if (sortedRow == null) {
      return new int[0][0];
    }
    int[] sortedCol = topologySort(k, colConditions);
    if (sortedCol == null) {
      return new int[0][0];
    }

    int[][] result = new int[k][k];
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k; j++) {
        if (sortedRow[i] == sortedCol[j]) {
          result[i][j] = sortedRow[i];
        }
      }
    }
    return result;
  }

  private int[] topologySort(int k, int[][] conditions) {
    Map<Integer, Set<Integer>> dependents = new HashMap<>();
    int[] indegree = new int[k + 1];
    for (int[] condition : conditions) {
      int first = condition[0];
      int next = condition[1];
      if (dependents.computeIfAbsent(first, f -> new HashSet<>()).add(next)) {
        indegree[next]++;
      }
    }

    int[] result = new int[k];
    int index = 0;

    Queue<Integer> nodes = new LinkedList<>();
    for (int i = 1; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        nodes.add(i);
      }
    }

    while (!nodes.isEmpty()) {
      int node = nodes.remove();
      result[index] = node;
      index++;

      if (!dependents.containsKey(node)) {
        continue;
      }

      for (int dependent : dependents.get(node)) {
        indegree[dependent]--;
        if (indegree[dependent] == 0) {
          nodes.add(dependent);
        }
      }
    }

    return index == k ? result : null;
  }
}