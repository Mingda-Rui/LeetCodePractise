package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0064MinimumPathSum {}

class LC0064Solution {

  public int minPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    for (int[] dpRow : dp) {
      Arrays.fill(dpRow, -1);
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    return findMinPathSum(grid, 0, 0, dp);
  }

  private int findMinPathSum(int[][] grid, int row, int column, int[][] dp) {
    if (row >= grid.length || column >= grid[0].length) {
      return Integer.MAX_VALUE;
    }
    if (row == grid.length - 1 && column == grid[0].length - 1) {
      return grid[row][column];
    }
    if (dp[row][column] != -1) {
      return dp[row][column];
    }

    int moveRight = findMinPathSum(grid, row, column + 1, dp);
    int moveDown = findMinPathSum(grid, row + 1, column, dp);

    dp[row][column] = grid[row][column] + Math.min(moveRight, moveDown);
    return dp[row][column];
  }
}
