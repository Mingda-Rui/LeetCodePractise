package pers.mingda.leetcode;

public class LC1406StoneGameIII {
}


class LC1406Solution {
  public String stoneGameIII(int[] stoneValue) {
    int[] memo = new int[stoneValue.length + 1];
    for (int i = stoneValue.length - 1; i >= 0; i--) {
      int max = Integer.MIN_VALUE;
      int score = stoneValue[i];
      max = Math.max(max, score - memo[i + 1]);
      if (i + 1 < stoneValue.length) {
        score += stoneValue[i + 1];
        max = Math.max(max, score - memo[i + 2]);
      }
      if (i + 2 < stoneValue.length) {
        score += stoneValue[i + 2];
        max = Math.max(max,score - memo[i + 3]);
      }
      memo[i] = max;
    }

    return memo[0] > 0 ? "Alice" : (memo[0] < 0 ? "Bob" : "Tie");
  }
}