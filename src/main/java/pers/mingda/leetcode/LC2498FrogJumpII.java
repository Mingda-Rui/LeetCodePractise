package pers.mingda.leetcode;

public class LC2498FrogJumpII {}

class LC2498Solution {
  public int maxJump(int[] stones) {
    int result = 0;
    for (int i = 1; i < stones.length; i++) {
      int prevStep = Math.max(0, i - 2);
      result = Math.max(result, stones[i] - stones[prevStep]);
    }
    return result;
  }
}
