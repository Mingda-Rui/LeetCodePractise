package pers.mingda.leetcode;

public class LC0304RangeSumQuery2DImmutable {}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
class LC0304NumMatrix {

  int[][] summedMatrix;

  public LC0304NumMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    summedMatrix = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        summedMatrix[i][j] =
          matrix[i][j] + getSum(i - 1, j) + getSum(i, j - 1) - getSum(i - 1, j - 1);
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return (
      getSum(row2, col2) -
      getSum(row1 - 1, col2) -
      getSum(row2, col1 - 1) +
      getSum(row1 - 1, col1 - 1)
    );
  }

  private int getSum(int row, int col) {
    if (row < 0 || row >= summedMatrix.length || col < 0 || col >= summedMatrix[0].length) {
      return 0;
    }
    return summedMatrix[row][col];
  }
}
