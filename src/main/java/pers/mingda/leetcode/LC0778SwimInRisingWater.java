package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0778SwimInRisingWater {

  public int swimInWater(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int maxElevation = 0;

    boolean[][] visited = new boolean[row][col];
    Queue<LC0778Node> queue = new PriorityQueue<>(
      Comparator.comparingInt(n -> n.val)
    );
    LC0778Node dest = new LC0778Node(row - 1, col - 1, grid);
    queue.add(dest);
    visited[row - 1][col - 1] = true;

    while (!queue.isEmpty()) {
      LC0778Node node = queue.poll();
      maxElevation = Math.max(maxElevation, node.val);
      if (node.isTopLeft()) {
        return maxElevation;
      }
      exploreNode(node, queue, grid, visited);
    }
    return maxElevation;
  }

  private void exploreNode(
    LC0778Node node,
    Queue<LC0778Node> queue,
    int[][] grid,
    boolean[][] visited
  ) {
    if (node.row - 1 >= 0 && !visited[node.row - 1][node.col]) {
      LC0778Node top = new LC0778Node(node.row - 1, node.col, grid);
      queue.add(top);
      visited[node.row - 1][node.col] = true;
    }

    if (node.col - 1 >= 0 && !visited[node.row][node.col - 1]) {
      LC0778Node left = new LC0778Node(node.row, node.col - 1, grid);
      queue.add(left);
      visited[node.row][node.col - 1] = true;
    }

    if (node.row + 1 < grid.length && !visited[node.row + 1][node.col]) {
      LC0778Node bottom = new LC0778Node(node.row + 1, node.col, grid);
      queue.add(bottom);
      visited[node.row + 1][node.col] = true;
    }

    if (node.col + 1 < grid[0].length && !visited[node.row][node.col + 1]) {
      LC0778Node right = new LC0778Node(node.row, node.col + 1, grid);
      queue.add(right);
      visited[node.row][node.col + 1] = true;
    }
  }
}

class LC0778Node {

  int row;
  int col;
  int val;

  public LC0778Node(int row, int col, int[][] grid) {
    this.row = row;
    this.col = col;
    this.val = grid[row][col];
  }

  public boolean isTopLeft() {
    return row == 0 && col == 0;
  }
}
