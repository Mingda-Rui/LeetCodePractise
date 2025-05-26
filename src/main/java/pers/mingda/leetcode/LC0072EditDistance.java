package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0072EditDistance {

  public int minDistance(String word1, String word2) {
    int[][] memo = new int[word1.length()][word2.length()];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return findMinDistance(word1, 0, word2, 0, memo);
  }

  private int findMinDistance(
    String word1,
    int i1,
    String word2,
    int i2,
    int[][] memo
  ) {
    if (i2 == word2.length()) {
      return word1.length() - i1;
    }
    if (i1 == word1.length()) {
      return word2.length() - i2;
    }

    if (memo[i1][i2] != -1) {
      return memo[i1][i2];
    }

    int dist = Integer.MAX_VALUE;

    boolean matched = word1.charAt(i1) == word2.charAt(i2);
    int replaceOrMatchOffset = matched ? 0 : 1;
    dist = Math.min(
      dist,
      findMinDistance(word1, i1 + 1, word2, i2 + 1, memo) + replaceOrMatchOffset
    );
    dist = Math.min(dist, findMinDistance(word1, i1 + 1, word2, i2, memo) + 1);
    dist = Math.min(dist, findMinDistance(word1, i1, word2, i2 + 1, memo) + 1);

    memo[i1][i2] = dist;
    return dist;
  }

  public int minDistanceIterative(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int add = dp[i][j - 1] + 1;
          int remove = dp[i - 1][j] + 1;
          int replace = dp[i - 1][j - 1] + 1;
          dp[i][j] = Math.min(add, Math.min(remove, replace));
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
