package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC1135ConnectingCitiesWithMinimumCost {
}

class LC1135KruskalSolution {
  public int minimumCost(int n, int[][] connections) {
    LC1135UnionFind uf = new LC1135UnionFind(n + 1);
    Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
    int totalCost = 0;
    int edgeCount = 0;
    for (int[] connection : connections) {
      int x = connection[0];
      int y = connection[1];
      int cost = connection[2];
      if (uf.find(x) == uf.find(y)) {
        continue;
      }
      uf.union(x, y);
      totalCost += cost;
      edgeCount++;
    }

    return edgeCount == n - 1 ? totalCost : -1;
  }
}

class LC1135UnionFind {

  final private int[] parent;
  final private int[] rank;

  public LC1135UnionFind(int size) {
    this.parent = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
  }

  public void union(int node1, int node2) {
    int parent1 = parent[node1];
    int parent2 = parent[node2];
    if (parent1 == parent2) {
      return;
    }

    if (rank[parent1] > rank[parent2]) {
      parent[parent2] = parent1;
    } else if (rank[parent2] > rank[parent1]) {
      parent[parent1] = parent2;
    } else {
      parent[parent2] = parent1;
      rank[parent1]++;
    }
  }

  public int find(int node) {
    if (parent[node] != node) {
      int currentParent = parent[node];
      parent[node] = find(currentParent);
    }
    return parent[node];
  }
}