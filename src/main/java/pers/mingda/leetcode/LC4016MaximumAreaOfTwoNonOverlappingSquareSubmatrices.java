package pers.mingda.leetcode;

public class LC4016MaximumAreaOfTwoNonOverlappingSquareSubmatrices {}

class LC4016Solution {
  public int maxArea(int[][] mat) {
    int r = mat.length;
    int c = mat[0].length;
    int[][] pf = new int[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        int leftSum = j == 0 ? 0 : pf[i][j - 1];
        int upSum = i == 0 ? 0 : pf[i - 1][j];
        int diagonalSum = (i == 0 || j == 0) ? 0 : pf[i - 1][j - 1];
        pf[i][j] = leftSum + upSum - diagonalSum + mat[i][j];
      }
    }

    for (int k = Math.min(r, c); k > 0; k--) {
      int minLeft = c;
      int maxLeft = 0;
      int minUp = r;
      int maxUp = 0;

      for (int i = k - 1; i < r; i++) {
        for (int j = k - 1; j < c; j++) {
          if (isSquare(pf, i, j, k)) {
            minLeft = Math.min(minLeft, j - k + 1);
            maxLeft = Math.max(maxLeft, j - k + 1);
            minUp = Math.min(minUp, i - k + 1);
            maxUp = Math.max(maxUp, i - k + 1);
          }
        }
      }

      if (maxLeft - minLeft >= k || maxUp - minUp >= k) {
        return k * k;
      }
    }
    return 0;
  }

  private boolean isSquare(int[][] pf, int i, int j, int k) {
    int leftCount = j - k < 0 ? 0 : pf[i][j - k];
    int upCount = i - k < 0 ? 0 : pf[i - k][j];
    int diagonalCount = (i - k < 0 || j - k < 0) ? 0 : pf[i - k][j - k];
    int count = pf[i][j] - leftCount - upCount + diagonalCount;
    return count == k * k;
  }
}

class LC4016BinarySearchSolution {

  public int maxArea(int[][] mat) {
    int r = mat.length;
    int c = mat[0].length;
    int[][] pf = new int[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        int leftSum = j == 0 ? 0 : pf[i][j - 1];
        int upSum = i == 0 ? 0 : pf[i - 1][j];
        int diagonalSum = (i == 0 || j == 0) ? 0 : pf[i - 1][j - 1];
        pf[i][j] = mat[i][j] == 0 ? 0 : Math.min(Math.min(leftSum, upSum), diagonalSum) + 1;
      }
    }

    int k = binarySearch(r, c, pf);
    return k * k;
  }

  private int binarySearch(int r, int c, int[][] pf) {
    int start = 0;
    int end = Math.min(r, c) + 1;
    while (start + 1 < end) {
      int k = (start + end) / 2;

      int minLeft = c;
      int maxLeft = 0;
      int minUp = r;
      int maxUp = 0;

      for (int i = k - 1; i < r; i++) {
        for (int j = k - 1; j < c; j++) {
          if (pf[i][j] >= k) {
            minLeft = Math.min(minLeft, j - k + 1);
            maxLeft = Math.max(maxLeft, j - k + 1);
            minUp = Math.min(minUp, i - k + 1);
            maxUp = Math.max(maxUp, i - k + 1);
          }
        }
      }

      if (maxLeft - minLeft >= k || maxUp - minUp >= k) {
        start = k;
      } else {
        end = k;
      }
    }
    return start;
  }
}
