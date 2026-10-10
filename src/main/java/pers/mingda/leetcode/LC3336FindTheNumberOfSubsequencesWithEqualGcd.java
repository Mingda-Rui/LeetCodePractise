package pers.mingda.leetcode;

import java.util.Arrays;

public class LC3336FindTheNumberOfSubsequencesWithEqualGcd {
}

class LC3336TwoDimensionalDpSolution {
  public int subsequencePairCount(int[] nums) {
    int modulo = 1_000_000_007;

    int maxVal = Arrays.stream(nums).max().orElseThrow();
    int[][] gcdMap = new int[maxVal + 1][maxVal + 1];
    for (int i = 0; i <= maxVal; i++) {
      for (int j = 0; j <= maxVal; j++) {
        gcdMap[i][j] = gcd(i, j);
      }
    }

    int[][] dp = new int[maxVal + 1][maxVal + 1];
    dp[0][0] = 1;

    for (int num : nums) {
      int[][] nextDp = new int[maxVal + 1][maxVal + 1];
      for (int g1 = 0; g1 <= maxVal; g1++) {
        for (int g2 = 0; g2 <= maxVal; g2++) {
          if (dp[g1][g2] == 0) {
            continue;
          }
          nextDp[g1][g2] = (nextDp[g1][g2] + dp[g1][g2]) % modulo;

          int newG1 = gcdMap[num][g1];
          nextDp[newG1][g2] = (nextDp[newG1][g2] + dp[g1][g2]) % modulo;

          int newG2 = gcdMap[num][g2];
          nextDp[g1][newG2] = (nextDp[g1][newG2] + dp[g1][g2]) % modulo;
        }
      }
      dp = nextDp;
    }

    int result = 0;
    for (int i = 1; i <= maxVal; i++) {
      result = (result + dp[i][i]) % modulo;
    }
    return result;
  }

  private int gcd(int num1, int num2) {
    while (num2 != 0) {
      int tmp = num2;
      num2 = num1 % num2;
      num1 = tmp;
    }
    return num1;
  }
}