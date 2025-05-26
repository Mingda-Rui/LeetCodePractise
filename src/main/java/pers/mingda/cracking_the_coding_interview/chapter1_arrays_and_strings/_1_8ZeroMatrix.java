package pers.mingda.cracking_the_coding_interview.chapter1_arrays_and_strings;

/**
 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 */
public class _1_8ZeroMatrix {

  public static void setZeros(int[][] matrix) {
    boolean[] zeroRows = new boolean[matrix.length];
    boolean[] zeroColumns = new boolean[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          zeroRows[i] = true;
          zeroColumns[j] = true;
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (zeroRows[i] || zeroColumns[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public static void setZerosNoExtraSpace(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        setZerosRowAndColumn(matrix, i, -1);
      }
    }

    for (int j = 1; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        setZerosRowAndColumn(matrix, -1, j);
      }
    }

    if (matrix[0][0] == 0) {
      setZerosRowAndColumn(matrix, 0, 0);
    }
  }

  private static void setZerosRowAndColumn(
    int[][] matrix,
    int row,
    int column
  ) {
    if (row >= 0) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[row][j] = 0;
      }
    }
    if (column >= 0) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][column] = 0;
      }
    }
  }
}
