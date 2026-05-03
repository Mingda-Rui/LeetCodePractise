package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1631PathWithMinimumEffort {
}

class LC1632Solution {
  public int minimumEffortPath(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;

    int[][] efforts = new int[rows][cols];
    for (int[] row : efforts) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    Comparator<LC1631Cell> effortComparator = Comparator.comparingInt(LC1631Cell::effort);
    Queue<LC1631Cell> pq = new PriorityQueue<>(effortComparator);
    pq.add(new LC1631Cell(0, 0, 0));
    while (!pq.isEmpty()) {
      LC1631Cell c = pq.remove();
      if (c.row() == rows - 1 && c.col() == cols - 1) {
        return c.effort();
      }
      for (int i = c.row() - 1; i <= c.row() + 1; i++) {
        for (int j = c.col() - 1; j <= c.col() + 1; j++) {
          if (i < 0 || i >= rows || j < 0 || j >= cols) {
            continue;
          }
          if (Math.abs(i - c.row()) == Math.abs(j - c.col())) {
            continue;
          }
          int newEffort = Math.max(c.effort(), Math.abs(heights[c.row()][c.col()] - heights[i][j]));
          if (newEffort < efforts[i][j]) {
            efforts[i][j] = newEffort;
            pq.add(new LC1631Cell(i, j, newEffort));
          }
        }
      }
    }
    return efforts[rows - 1][cols - 1];
  }
}

record LC1631Cell(int row, int col, int effort){}

class LC1631UnionFindSolution {
  public int minimumEffortPath(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    Comparator<LC1631Edge> edgeComparator = Comparator.comparingInt(LC1631Edge::diff);
    Queue<LC1631Edge> nonDecreaseEdges = new PriorityQueue<>(edgeComparator);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int flatten = flatten(i, j, cols);
        if (i + 1 < rows) {
          LC1631Edge toBelow = new LC1631Edge(flatten, flatten(i + 1, j, cols), getDiff(i, j, 1, 0, heights));
          nonDecreaseEdges.add(toBelow);
        }
        if (j + 1 < cols) {
          LC1631Edge toRight = new LC1631Edge(flatten, flatten(i, j + 1, cols), getDiff(i, j, 0, 1, heights));
          nonDecreaseEdges.add(toRight);
        }
      }
    }

    LC1631UnionFind uf = new LC1631UnionFind(rows * cols);
    int start = flatten(0, 0, cols);
    int end = flatten(rows - 1, cols - 1, cols);
    while (!nonDecreaseEdges.isEmpty()) {
      LC1631Edge edge = nonDecreaseEdges.remove();
      uf.union(edge);
      if (uf.find(start) == uf.find(end)) {
        return edge.diff();
      }
    }
    return 0;
  }

  private int flatten(int row, int col, int cols) {
    return row * cols + col;
  }

  private int getDiff(int row, int col, int rowOffset, int colOffset, int[][] heights) {
    int height1 = heights[row][col];
    int height2 = heights[row + rowOffset][col + colOffset];
    return Math.abs(height1 - height2);
  }
}

class LC1631UnionFind {
  private final int[] parent;
  private final int[] size;

  public LC1631UnionFind(int size) {
    this.parent = new int[size];
    this.size = new int[size];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
  }

  public void union(LC1631Edge edge) {
    int parent1 = find(edge.start());
    int parent2 = find(edge.end());

    if (parent1 == parent2) {
      return;
    }

    if (size[parent1] > size[parent2]) {
      parent[parent2] = parent1;
      size[parent1] += size[parent2];
    } else {
      parent[parent1] = parent2;
      size[parent2] += size[parent1];
    }
  }

  public int find(int node) {
    if (parent[node] == node) {
      return node;
    }

    parent[node] = find(parent[node]);
    return parent[node];
  }
}

record LC1631Edge(int start, int end, int diff){};