package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_10PaintFill {
  // args can be designed as classes, e.g. Point
  public void doPaintFill(int[][] matrix, int row, int col, int targetColor) {
    int originalColor = matrix[row][col];
    if (originalColor == targetColor) {
      return;
    }
    doPaintFill(matrix, row, col, originalColor, targetColor);
  }

  private void doPaintFill(int[][] matrix, int row, int col, int originalColor, int targetColor) {
    if (row >= matrix.length || col >= matrix[0].length) {
      return;
    }

    int currentColor = matrix[row][col];
    if (currentColor == originalColor) {
      matrix[row][col] = targetColor;
    } else {
      return;
    }
    doPaintFill(matrix, row + 1, col, originalColor, targetColor);
    doPaintFill(matrix, row - 1, col, originalColor, targetColor);
    doPaintFill(matrix, row, col + 1, originalColor, targetColor);
    doPaintFill(matrix, row, col - 1, originalColor, targetColor);
  }
}
