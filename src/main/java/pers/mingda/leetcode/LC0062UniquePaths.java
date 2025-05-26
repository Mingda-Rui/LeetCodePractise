package pers.mingda.leetcode;

public class LC0062UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] record = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int top = i - 1 < 0 ? 0 : record[i - 1][j];
        int left = j - 1 < 0 ? 0 : record[i][j - 1];
        int total = Math.max(top + left, 1);
        record[i][j] = total;
      }
    }
    return record[m - 1][n - 1];
  }
}
