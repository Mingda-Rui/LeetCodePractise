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
      return -1;
    }
    if (dp[row][column] != -1) {
      return dp[row][column];
    }
    int val = grid[row][column];
    int moveRight = findMinPathSum(grid, row, column + 1, dp);
    int moveDown = findMinPathSum(grid, row + 1, column, dp);

    if (moveRight >= 0 && moveDown >= 0) {
      val += Math.min(moveRight, moveDown);
    } else if (moveRight >= 0) {
      val += moveRight;
    } else if (moveDown >= 0) {
      val += moveDown;
    }
    dp[row][column] = val;
    return val;
  }
}
