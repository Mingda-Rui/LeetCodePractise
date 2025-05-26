package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0115DistinctSubsequences {
  public int numDistinct(String s, String t) {
    int[][] memo = new int[s.length()][t.length()];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return findNumDistinct(s, 0, t, 0, memo);
  }

  private int findNumDistinct(String s, int sI, String t, int tI, int[][] memo) {
    if (tI == t.length()) {
      return 1;
    }
    if (sI == s.length()) {
      return 0;
    }
    if (memo[sI][tI] != -1) {
      return memo[sI][tI];
    }
    int count = 0;
    if (s.charAt(sI) == t.charAt(tI)) {
      count += findNumDistinct(s, sI + 1, t, tI + 1, memo);
    }
    count += findNumDistinct(s, sI + 1, t, tI, memo);
    memo[sI][tI] = count;
    return count;
  }

  public int numDistinct1DimensionalDp(String s, String t) {
    int[] dp = new int[t.length() + 1];
    dp[t.length()] = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      int prev = dp[t.length()];
      for (int j = t.length() - 1; j >= 0; j--) {
        int oldVal = dp[j];
        if (s.charAt(i) == t.charAt(j)) {
          dp[j] += prev;
        }
        prev = oldVal;
      }
    }
    return dp[0];
  }
}
