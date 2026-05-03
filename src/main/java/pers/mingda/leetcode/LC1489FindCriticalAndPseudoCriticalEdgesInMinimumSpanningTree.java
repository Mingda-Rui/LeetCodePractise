package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC1489FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {
}

class LC1489Solution {
  public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
    int[][] newEdges = new int[edges.length][4];
    for (int i = 0; i < edges.length; i++) {
      System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
      newEdges[i][3] = i;
    }
    Arrays.sort(newEdges, Comparator.comparingInt(e -> e[2]));

    int minimumMstWeight = getMinimumMstWeight(newEdges, n, null, null);
    List<List<Integer>> result = new ArrayList<>(2);
    for (int i = 0; i < 2; i++) {
      result.add(new ArrayList<>());
    }
    for (int[] edge : newEdges) {
      if (getMinimumMstWeight(newEdges, n, edge, null) != minimumMstWeight) {
        result.getFirst().add(edge[3]);
      } else if (getMinimumMstWeight(newEdges, n, null, edge) == minimumMstWeight) {
        result.get(1).add(edge[3]);
      }
    }
    return result;
  }

  private int getMinimumMstWeight(int[][] sortedEdges, int n, int[] ignoredEdge, int[] enforcedEdge) {
    L1489UnionFind uf = new L1489UnionFind(n);
    int minMstWeight = enforcedEdge == null ? 0 : enforcedEdge[2];
    int usedEdgeCount = enforcedEdge == null ? 0 : 1;
    if (enforcedEdge != null) {
      uf.union(enforcedEdge[0], enforcedEdge[1]);
    }

    for (int[] edge : sortedEdges) {
      int start = edge[0];
      int end = edge[1];
      int weight = edge[1];
      if (Arrays.equals(edge, ignoredEdge)) {
        continue;
      }
      if (uf.find(start) == uf.find(end)) {
        continue;
      }
      uf.union(start, end);
      minMstWeight += edge[2];
      usedEdgeCount++;
    }
    return usedEdgeCount == n - 1 ? minMstWeight : -1;
  }
}

class L1489UnionFind {

  final private int[] parents;
  final private int[] ranks;

  public L1489UnionFind(int size) {
    this.parents = new int[size];
    this.ranks = new int[size];

    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }
  }

  public void union(int node1, int node2) {
    int parent1 = parents[node1];
    int parent2 = parents[node2];

    if (parent1 == parent2) {
      return;
    }

    if (ranks[parent1] > ranks[parent2]) {
      parents[parent2] = parent1;
    } else if (ranks[parent1] < ranks[parent2]) {
      parents[parent1] = parent2;
    } else {
      parents[parent2] = parent1;
      ranks[parent1]++;
    }
  }

  public int find(int node) {
    if (parents[node] != node) {
      int currentP = parents[node];
      parents[node] = find(currentP);
    }

    return parents[node];
  }
}