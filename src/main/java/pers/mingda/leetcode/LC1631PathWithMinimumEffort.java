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