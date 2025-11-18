package pers.mingda.leetcode;

public class LC0063UniquePathsII {}

class LC0063Solution {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
          continue;
        }
        if (i == 0 && j == 0) {
          obstacleGrid[i][j] = 1;
          continue;
        }

        int left = j == 0 ? 0 : obstacleGrid[i][j - 1];
        int up = i == 0 ? 0 : obstacleGrid[i - 1][j];
        obstacleGrid[i][j] = left + up;
      }
    }
    return obstacleGrid[row - 1][col - 1];
  }
}
