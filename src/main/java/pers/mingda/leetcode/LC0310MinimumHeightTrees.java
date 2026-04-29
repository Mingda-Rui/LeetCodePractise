package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class LC0310MinimumHeightTrees {
}

class LC0310Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return List.of(0);
    }
    Map<Integer, Set<Integer>> neighbors = new HashMap<>();
    for (int[] edge : edges) {
      neighbors.computeIfAbsent(edge[0], e -> new HashSet<>()).add(edge[1]);
      neighbors.computeIfAbsent(edge[1], e -> new HashSet<>()).add(edge[0]);
    }

    Queue<Integer> leaves = new LinkedList<>();
    leaves.addAll(findLeaves(neighbors));
    while (!leaves.isEmpty() && neighbors.size() > 2) {
      int size = leaves.size();
      for (int i = 0; i < size; i++) {
        int leave = leaves.remove();
        removeLeave(leave, neighbors).ifPresent(l -> leaves.add(l));
      }
    }
    return neighbors.keySet().stream().toList();
  }

  private List<Integer> findLeaves(Map<Integer, Set<Integer>> neighbors) {
    List<Integer> leaves = new ArrayList<>();
    if (neighbors.size() <= 2) {
      return leaves;
    }
    for (int node : neighbors.keySet()) {
      if (neighbors.get(node).size() == 1) {
        leaves.add(node);
      }
    }
    return leaves;
  }

  private Optional<Integer> removeLeave(int leave, Map<Integer, Set<Integer>> neighbors) {
    if (!neighbors.containsKey(leave) || neighbors.get(leave).size() > 1) {
      return Optional.empty();
    }

    for (int neighbor : neighbors.get(leave)) {
      neighbors.get(neighbor).remove(leave);
      neighbors.remove(leave);
      if (neighbors.get(neighbor).size() == 1) {
        return Optional.of(neighbor);
      }
    }
    return Optional.empty();
  }
}