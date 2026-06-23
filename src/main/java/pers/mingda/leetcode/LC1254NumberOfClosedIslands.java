package pers.mingda.leetcode;

public class LC1254NumberOfClosedIslands {}

class LC1254Solution {
  public int closedIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (visited[i][j] || grid[i][j] == 1) {
          continue;
        }
        if (isClosedIsland(grid, visited, i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isClosedIsland(int[][] grid, boolean[][] visited, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
      return false;
    }

    if (visited[x][y] || grid[x][y] == 1) {
      return true;
    }

    visited[x][y] = true;

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean isClosedIsland = true;
    for (int[] direction : directions) {
      int nX = x + direction[0];
      int nY = y + direction[1];
      isClosedIsland &= isClosedIsland(grid, visited, nX, nY);
    }
    return isClosedIsland;
  }
}
