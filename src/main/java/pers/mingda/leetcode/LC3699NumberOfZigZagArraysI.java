package pers.mingda.leetcode;

import java.util.Arrays;

public class LC3699NumberOfZigZagArraysI {
}

class LC3699DpSolution {
  public int zigZagArrays(int n, int l, int r) {
    int modulo = 1_000_000_007;
    int[] dp1 = new int[r + 1];
    int[] dp2 = new int[r + 1];

    int[] prefixSum1 = new int[r + 1];
    int[] prefixSum2 = new int[r + 1];

    for (int i = l; i <= r; i++) {
      prefixSum1[i] = prefixSum1[i - 1] + 1;
      prefixSum2[i] = prefixSum2[i - 1] + 1;
    }

    for (int len = 1; len < n; len++) {
      for (int curr = l; curr <= r; curr++) {
        dp1[curr] = prefixSum2[curr - 1];
        dp1[curr] %= modulo;

        dp2[curr] = (prefixSum1[r] - prefixSum1[curr] + modulo) % modulo;
        dp2[curr] %= modulo;
      }

      for (int curr = l; curr <= r; curr++) {
        prefixSum1[curr] = (prefixSum1[curr - 1] + dp1[curr]) % modulo;
        prefixSum2[curr] = (prefixSum2[curr - 1] + dp2[curr]) % modulo;
      }
    }

    return (prefixSum1[r] + prefixSum2[r]) % modulo;
  }
}

class LC36991DDPSolution {
  public int zigZagArrays(int n, int l, int r) {
    int modulo = 1_000_000_007;
    int[] dp = new int[r - l + 1];
    Arrays.fill(dp, 1);

    for (int len = 2; len <= n; len++) {
      int sum = 0;
      if (len % 2 == 0) {
        for (int curr = 0; curr < dp.length; curr++) {
          int val = dp[curr];
          dp[curr] = sum;
          sum = (sum + val) % modulo;
        }
      } else {
        for (int curr = dp.length - 1; curr >= 0; curr--) {
          int val = dp[curr];
          dp[curr] = sum;
          sum = (sum + val) % modulo;
        }
      }
    }

    int count = 0;
    for (int val : dp) {
      count += val;
      count %= modulo;
    }
    return (2 * count) % modulo;
  }
}