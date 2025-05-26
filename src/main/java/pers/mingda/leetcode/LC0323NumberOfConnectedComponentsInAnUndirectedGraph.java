package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0323NumberOfConnectedComponentsInAnUndirectedGraph {}

class LC0323LC0323UnionFindSolution {

  public int countComponents(int n, int[][] edges) {
    LC0323UnionFind uf = new LC0323UnionFind(n);
    for (int[] edge : edges) uf.union(edge[0], edge[1]);
    return uf.getSetCount();
  }
}

class LC0323UnionFind {

  private int[] parent;
  private int setCount;

  public LC0323UnionFind(int n) {
    this.parent = new int[n];
    this.setCount = n;
    for (int i = 0; i < n; i++) parent[i] = i;
  }

  private int find(int node) {
    while (parent[node] != node) node = parent[node];
    return node;
  }

  public void union(int node1, int node2) {
    int root1 = find(node1);
    int root2 = find(node2);
    if (root1 != root2) setCount--;
    parent[root1] = root2;
  }

  public int getSetCount() {
    return setCount;
  }
}

class LC0323DfsSolution {

  public int countComponents(int n, int[][] edges) {
    Set<Integer> unvisited = new HashSet<>();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      unvisited.add(i);
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    int counter = 0;
    while (!unvisited.isEmpty()) {
      int node = unvisited.stream().findFirst().get();
      traverseSet(node, unvisited, graph);
      counter++;
    }

    return counter;
  }

  private void traverseSet(
    int node,
    Set<Integer> unvisted,
    List<List<Integer>> graph
  ) {
    unvisted.remove(node);
    // System.out.println(unvisted.size());
    for (int neighbour : graph.get(node)) if (
      unvisted.contains(neighbour)
    ) traverseSet(neighbour, unvisted, graph);
  }
}
