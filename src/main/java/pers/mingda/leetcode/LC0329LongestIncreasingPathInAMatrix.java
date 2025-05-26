package pers.mingda.leetcode;

public class LC0329LongestIncreasingPathInAMatrix {
  public int longestIncreasingPath(int[][] matrix) {
    int longest = 0;
    int[][] record = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        longest = Math.max(longest, longestIncreasingPathDfs(matrix, record, i, j, -1));
    return longest;
  }

  private int longestIncreasingPathDfs(int[][] matrix, int[][] record, int x, int y, int prevVal) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return 0;
    if (prevVal >= 0 && prevVal <= matrix[x][y]) return 0;
    if (record[x][y] != 0) return record[x][y];
    int longest = 0;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] dir : dirs) {
      int nextLen = longestIncreasingPathDfs(matrix, record, x + dir[0], y + dir[1], matrix[x][y]);
      longest = Math.max(longest, nextLen);
    }
    longest++;
    record[x][y] = longest;
    return longest;
  }
}
