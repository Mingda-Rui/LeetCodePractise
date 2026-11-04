package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0417PacificAtlanticWaterFlow {

  public List<List<Integer>> pacificAtlanticDfs(int[][] heights) {
    List<List<Integer>> result = new LinkedList<>();
    int[][] record = new int[heights.length][heights[0].length];
    int maxX = heights.length - 1;
    int maxY = heights[0].length - 1;
    for (int i = 0; i <= maxX; i++)
      for (int j = 0; j <= maxY; j++) if (i == 0 || j == 0) dfs(heights, record, i, j, 1);

    for (int i = 0; i <= maxX; i++)
      for (int j = 0; j <= maxY; j++) if (i == maxX || j == maxY) dfs(heights, record, i, j, 2);

    for (int i = 0; i < heights.length; i++)
      for (int j = 0; j < heights[0].length; j++)
        if (record[i][j] == 3) result.add(Arrays.asList(i, j));

    return result;
  }

  private void dfs(int[][] heights, int[][] record, int x, int y, int sea) {
    if (record[x][y] >= sea) return;
    record[x][y] += sea;
    int[][] neighbors =
        new int[][] {
          {0, 1},
          {0, -1},
          {1, 0},
          {-1, 0},
        };
    for (int[] neighbor : neighbors) {
      int nextX = x + neighbor[0];
      int nextY = y + neighbor[1];
      if (checkCoord(heights, nextX, nextY) && heights[nextX][nextY] >= heights[x][y])
        dfs(heights, record, nextX, nextY, sea);
    }
  }

  private boolean checkCoord(int[][] heights, int x, int y) {
    return x >= 0 && x < heights.length && y >= 0 && y < heights[0].length;
  }
}

class LC0417PacificAtlanticWaterFlowBfsSolution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    Queue<Integer> pacific = new LinkedList<>();
    Queue<Integer> atlantic = new LinkedList<>();

    int m = heights.length;
    int n = heights[0].length;

    for (int i = 0; i < m; i++) {
      pacific.add(i);
      pacific.add(0);
      atlantic.add(i);
      atlantic.add(n - 1);
    }

    for (int j = 0; j < n; j++) {
      pacific.add(0);
      pacific.add(j);
      atlantic.add(m - 1);
      atlantic.add(j);
    }

    boolean[][] pacificReachable = reachOcean(heights, pacific);
    boolean[][] atlanticReachable = reachOcean(heights, atlantic);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacificReachable[i][j] && atlanticReachable[i][j]) {
          result.add(List.of(i, j));
        }
      }
    }
    return result;
  }

  private boolean[][] reachOcean(int[][] heights, Queue<Integer> locations) {
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] reachable = new boolean[m][n];
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!locations.isEmpty()) {
      int i = locations.remove();
      int j = locations.remove();
      reachable[i][j] = true;
      for (int[] dir : directions) {
        int nextI = i + dir[0];
        int nextJ = j + dir[1];
        if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
          continue;
        }
        if (reachable[nextI][nextJ]) {
          continue;
        }
        if (heights[nextI][nextJ] >= heights[i][j]) {
          locations.add(nextI);
          locations.add(nextJ);
        }
      }
    }
    return reachable;
  }
}