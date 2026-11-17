package pers.mingda.leetcode;

public class LC1319NumberOfOperationsToMakeNetworkConnected {
}

class Solution {
  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    LC1319UnionFind uf = new LC1319UnionFind(n);
    for (int[] conn : connections) {
      uf.union(conn[0], conn[1]);
    }
    return uf.getIslands() - 1;
  }
}

class LC1319UnionFind {
  private final int[] parents;
  private final int[] sizes;
  private int islands;

  public LC1319UnionFind(int size) {
    this.parents = new int[size];
    this.sizes = new int[size];
    this.islands = size;
    for (int i = 0; i < size; i++) {
      parents[i] = i;
      sizes[i] = 1;
    }
  }

  public void union(int n1, int n2) {
    int p1 = find(n1);
    int p2 = find(n2);
    if (p1 == p2) {
      return;
    }
    if (sizes[p1] < sizes[p2]) {
      parents[p1] = p2;
    } else {
      parents[p2] = p1;
    }
    islands--;
  }

  public int find(int node) {
    if (parents[node] != node) {
      parents[node] = find(parents[node]);
    }
    return parents[node];
  }

  public int getIslands() {
    return islands;
  }
}