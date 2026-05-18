package pers.mingda.leetcode;

import java.util.Arrays;

public class LC1049LastStoneWeightII {
}

class LC1049Solution {
  public int lastStoneWeightII(int[] stones) {
    int sum = Arrays.stream(stones).sum();
    boolean[] dp = new boolean[sum + 1];
    for (int stone : stones) {
      for (int i = dp.length - 1; i > stone; i--) {
        if (dp[i - stone]) {
          dp[i] = true;
        }
      }
      dp[stone] = true;
    }


    for (int i = sum / 2; i >= 0; i--) {
      if (dp[i]) {
        return (sum - i) - i;
      }
    }
    return sum;
  }
}