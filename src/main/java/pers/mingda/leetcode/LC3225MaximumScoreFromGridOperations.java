package pers.mingda.leetcode;

public class LC3225MaximumScoreFromGridOperations {
}

class LC3225DpSolution {
  public long maximumScore(int[][] grid) {
    int n = grid.length;
    if (n <= 1) {
      return 0;
    }
    long[][] prefixSum = new long[n + 1][n];

    for (int col = 0; col < n; col++) {
      for (int height = 1; height <= n; height++) {
        int row = height - 1;
        prefixSum[height][col] = prefixSum[height - 1][col] + grid[row][col];
      }
    }
    long[][] dp = new long[n + 1][n + 1];
    for (int col = 0; col < n; col++) {
      long[][] nextDp = new long[n + 1][n + 1];

      for (int curr = 0; curr <= n; curr++) {
        // only next matters
        long[] prevPrefixMax = new long[n + 1];
        prevPrefixMax[0] = dp[0][curr];
        for (int prev = 1; prev <= n; prev++) {
          prevPrefixMax[prev] = Math.max(prevPrefixMax[prev - 1], dp[prev][curr]);
        }

        // only prev matters
        long[] prevSuffixMax = new long[n + 2];
        for (int prev = n; prev >= 0; prev--) {
          long suffixMax = Math.max(0, prefixSum[prev][col] - prefixSum[curr][col]);
          prevSuffixMax[prev] = Math.max(prevSuffixMax[prev + 1], suffixMax + dp[prev][curr]);
        }

        for (int next = 0; next <= n; next++) {
          long prevOnlyMax = col == 0 ? 0 : prevSuffixMax[next];
          long nextOnlyMax = col == n - 1 ? 0 : Math.max(0, prefixSum[next][col] - prefixSum[curr][col]) + prevPrefixMax[next];

          nextDp[curr][next] = Math.max(prevOnlyMax, nextOnlyMax);
        }
      }
      dp = nextDp;
    }
    long result = 0;
    for (int height = 0; height <= n; height++) {
      result = Math.max(result, dp[height][0]);
    }
    return result;
  }
}