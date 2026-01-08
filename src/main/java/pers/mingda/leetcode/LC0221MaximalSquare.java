package pers.mingda.leetcode;

public class LC0221MaximalSquare {}

class LC0221Solution {

  public int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] memo = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        memo[i][j] = -1;
      }
    }
    maximalSquare(matrix, 0, 0, memo);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        max = Math.max(max, memo[i][j]);
      }
    }
    return max * max;
  }

  private int maximalSquare(char[][] matrix, int row, int col, int[][] memo) {
    if (!inTable(matrix, row, col)) {
      return 0;
    }

    if (memo[row][col] != -1) {
      return memo[row][col];
    }

    int min = Integer.MAX_VALUE;
    min = Math.min(min, maximalSquare(matrix, row + 1, col, memo));
    min = Math.min(min, maximalSquare(matrix, row, col + 1, memo));
    min = Math.min(min, maximalSquare(matrix, row + 1, col + 1, memo));

    memo[row][col] = matrix[row][col] == '0' ? 0 : min + 1;
    return memo[row][col];
  }

  private boolean inTable(char[][] matrix, int row, int col) {
    if (matrix == null) {
      return false;
    }
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;
    return 0 <= row && row < maxRow && 0 <= col && col < maxCol;
  }
}

class LC0221TabulationSolution {

  public int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;

    int[] tab = new int[col + 1];
    int topLeft = 0;
    int maxLen = Integer.MIN_VALUE;
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        int temp = tab[j];
        if (matrix[i - 1][j - 1] == '1') {
          int top = tab[j];
          int left = tab[j - 1];

          int min = Math.min(top, Math.min(left, topLeft));
          tab[j] = min + 1;
          maxLen = Math.max(tab[j], maxLen);
        } else {
          tab[j] = 0;
        }
        topLeft = temp;
      }
    }
    return maxLen * maxLen;
  }
}
