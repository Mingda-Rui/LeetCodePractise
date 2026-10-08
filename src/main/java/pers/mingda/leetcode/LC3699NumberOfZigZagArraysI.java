package pers.mingda.leetcode;

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