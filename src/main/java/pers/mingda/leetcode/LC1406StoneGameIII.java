package pers.mingda.leetcode;

public class LC1406StoneGameIII {}

class LC1406Solution {
  public String stoneGameIII(int[] stoneValue) {
    int[] memo = new int[3];
    for (int i = stoneValue.length - 1; i >= 0; i--) {
      int max = Integer.MIN_VALUE;
      int score = stoneValue[i];
      max = Math.max(max, score - memo[(i + 1) % 3]);
      if (i + 1 < stoneValue.length) {
        score += stoneValue[i + 1];
        max = Math.max(max, score - memo[(i + 2) % 3]);
      }
      if (i + 2 < stoneValue.length) {
        score += stoneValue[i + 2];
        max = Math.max(max, score - memo[(i + 3) % 3]);
      }
      memo[i % 3] = max;
    }

    return memo[0] > 0 ? "Alice" : (memo[0] < 0 ? "Bob" : "Tie");
  }
}
