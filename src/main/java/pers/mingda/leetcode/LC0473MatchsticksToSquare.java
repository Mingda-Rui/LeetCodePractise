package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0473MatchsticksToSquare {

}

class LC0473Solution {
  public boolean makeSquare(int[] matchsticks) {
    int sum = sum(matchsticks);
    if (sum % 4 != 0) {
      return false;
    }

    Arrays.sort(matchsticks);

    int targetLen = sum / 4;
    int[] len = new int[4];
    return makeSquare(matchsticks, matchsticks.length - 1, len, targetLen);
  }

  private int sum(int[] matchsticks) {
    return Arrays.stream(matchsticks).sum();
  }

  private boolean makeSquare(int[] matchsticks, int index, int[] len, int targetLen) {
    if (index < 0) {
      return isSquare(len);
    }
    int stick = matchsticks[index];
    for (int side = 0; side < 4; side++) {
      if (len[side] + stick > targetLen) {
        continue;
      }
      len[side] += stick;
      if (makeSquare(matchsticks, index - 1, len, targetLen)) {
        return true;
      }
      len[side] -= stick;
    }
    return false;
  }

  private boolean isSquare(int[] len) {
    return len[0] == len[1] && len[0] == len[2] && len[0] == len[3];
  }
}
