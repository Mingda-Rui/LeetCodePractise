package pers.mingda.leetcode;

public class LC1140StoneGameII {
}

class LC1140Solution {
  public int stoneGameII(int[] piles) {
    int pilesLen = piles.length;
    int[][] memo = new int[pilesLen][pilesLen];
    int[] suffixSum = new int[pilesLen + 1];
    for (int i = pilesLen - 1; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + piles[i];
    }

    return stoneGameII(piles, suffixSum, 0, 1, memo);
  }

  private int stoneGameII(int[] piles, int[] suffixSum, int pointer, int M, int[][] memo) {
    if (pointer + 2 * M >= piles.length) {
      return suffixSum[pointer];
    }

    if (memo[pointer][M] != 0) {
      return memo[pointer][M];
    }

    int max = Integer.MIN_VALUE;
    for (int X = 1; X <= 2 * M; X++) {
      int take = suffixSum[pointer] - suffixSum[pointer + X];
      int opponentMax = stoneGameII(piles, suffixSum, pointer + X, Math.max(X, M), memo);
      max = Math.max(max, take + suffixSum[pointer + X] - opponentMax);
    }
    memo[pointer][M] = max;
    return max;
  }
}