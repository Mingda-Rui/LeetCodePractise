package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0994RottingOranges {}

class LC0994Solution {

  public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();

    int count = countOranges(grid);
    if (count == 0) return 0;
    enqueueRottenOranges(grid, queue);

    int minute = orangeRotting(grid, queue, count);
    return minute > 0 ? minute - 1 : minute;
  }

  private int countOranges(int[][] grid) {
    int count = 0;
    for (int[] row : grid) for (int orange : row) if (orange != 0) count++;
    return count;
  }

  private void enqueueRottenOranges(int[][] grid, Queue<int[]> queue) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          int[] point = { i, j };
          queue.offer(point);
        }
      }
    }
  }

  private int orangeRotting(int[][] grid, Queue<int[]> queue, int orangeCount) {
    if (orangeCount == 0) return 0;
    if (queue.isEmpty()) return -1;
    int size = queue.size();
    orangeCount -= size;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    for (int i = 0; i < size; i++) {
      int[] rottenOrange = queue.poll();
      for (int[] dir : dirs) {
        int neighX = rottenOrange[0] + dir[0];
        int neighY = rottenOrange[1] + dir[1];
        if (checkBoundary(grid, neighX, neighY) && grid[neighX][neighY] == 1) {
          int[] point = { neighX, neighY };
          queue.offer(point);
          grid[neighX][neighY] = 2;
        }
      }
    }
    int minute = orangeRotting(grid, queue, orangeCount);
    return minute == -1 ? minute : minute + 1;
  }

  private boolean checkBoundary(int[][] grid, int x, int y) {
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
  }
}
