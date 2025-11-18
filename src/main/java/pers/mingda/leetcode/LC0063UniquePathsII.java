package pers.mingda.leetcode;

public class LC0063UniquePathsII {}

class LC0063Solution {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;
    int[][] count = new int[row][col];
    count[row - 1][col - 1] = 1;
    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        recordRoutes(obstacleGrid, count, i, j);
      }
    }
    return count[0][0];
  }

  private void recordRoutes(int[][] obstacleGrid, int[][] count, int row, int col) {
    if (isBottomRightCorner(obstacleGrid, row, col)) {
      return;
    }

    if (obstacleGrid[row][col] == 1) {
      return;
    }
    int down = col + 1;
    int downNeighbor = (down >= obstacleGrid[0].length || obstacleGrid[row][down] == 1)
      ? 0
      : count[row][down];
    int right = row + 1;
    int rightNeighbor = (right >= obstacleGrid.length || obstacleGrid[right][col] == 1)
      ? 0
      : count[right][col];
    count[row][col] = downNeighbor + rightNeighbor;
  }

  private boolean isBottomRightCorner(int[][] obstacleGrid, int row, int col) {
    return row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1;
  }
}
