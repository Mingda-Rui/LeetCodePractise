package pers.mingda.leetcode;

public class LC1871JumpGameVII {
}

class LC1871Solution {
  public boolean canReach(String s, int minJump, int maxJump) {
    boolean reachable = false;
    int sLen = s.length();
    if (s.charAt(sLen - 1) != '0') {
      return false;
    }

    int[] pre = new int[sLen];
    for (int i = 0; i < minJump; i++) {
      pre[i] = 1;
    }

    for (int i = 1; i < sLen; i++) {
      int nearest = i - minJump;
      if (s.charAt(i) != '0' || nearest < 0) {
        pre[i] = pre[i - 1];
        continue;
      }

      int furthest = Math.max(0, i - maxJump);
      reachable = furthest == 0 || (pre[nearest] - pre[furthest - 1]) > 0;
      pre[i] = pre[i - 1] + (reachable ? 1 : 0);
    }

    return reachable;
  }
}