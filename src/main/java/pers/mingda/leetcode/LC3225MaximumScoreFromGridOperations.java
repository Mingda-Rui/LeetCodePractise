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

class LC3225OneDimensionDpSolution {
  public long maximumScore(int[][] grid) {
    int n = grid.length;

    // colPrefix[col][prefixSum]
    long[][] colPrefix = new long[n][n + 1];
    for (int col = 0; col < n; col++) {
      long sum = 0;
      for (int r = 1; r <= n; r++) {
        sum += grid[r - 1][col];
        colPrefix[col][r] = sum;
      }
    }

    // prevScoredByLeft[height];
    long[] prevScoredByLeft = new long[n + 1];
    long[] prevUnscoredByLeft = new long[n + 1];
    for (int col = 1; col < n; col++) {
      int prevCol = col - 1;
      long[] scoredByLeft = new long[n + 1];
      long[] unscoredByLeft = new long[n + 1];
      for (int currH = 0; currH <= n; currH++) {
        for (int prevH = 0; prevH <= n; prevH++) {

          if (currH >= prevH) {
            long prevColScore = colPrefix[prevCol][currH] - colPrefix[prevCol][prevH];
            long maxPrevColScore = Math.max(prevScoredByLeft[prevH], prevUnscoredByLeft[prevH] + prevColScore);

            scoredByLeft[currH] = Math.max(scoredByLeft[currH], maxPrevColScore);
            unscoredByLeft[currH] = Math.max(unscoredByLeft[currH], maxPrevColScore);
          } else {
            long currScore = colPrefix[col][prevH] - colPrefix[col][currH];
            scoredByLeft[currH] = Math.max(scoredByLeft[currH], prevScoredByLeft[prevH] + currScore);
            unscoredByLeft[currH] = Math.max(unscoredByLeft[currH], prevScoredByLeft[prevH]);
          }
        }
      }

      prevScoredByLeft = scoredByLeft;
      prevUnscoredByLeft = unscoredByLeft;
    }

    long result = 0;
    for (long score : prevScoredByLeft) {
      result = Math.max(result, score);
    }
    return result;
  }
}