package pers.mingda.leetcode;

public class LC0463IslandPerimeter {

  private int[][] dirs = { { -1, 0 }, { 0, -1 } };

  public int islandPerimeter(int[][] grid) {
    int perimeter = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) perimeter += countWaterSides(grid, i, j);
      }
    }
    return perimeter;
  }

  private int countWaterSides(int[][] grid, int x, int y) {
    int count = 4;
    for (int[] dir : dirs) {
      int neighX = x + dir[0];
      int neighY = y + dir[1];
      if (
        boardCheck(grid, neighX, neighY) && grid[neighX][neighY] == 1
      ) count -= 2;
    }
    return count;
  }

  private boolean boardCheck(int[][] grid, int x, int y) {
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
  }
}
