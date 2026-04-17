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


class LC0473DpSolution {
  public boolean makeSquare(int[] matchsticks) {
    int sum = sum(matchsticks);
    if (sum % 4 != 0) {
      return false;
    }

    Arrays.sort(matchsticks);

    int targetLen = sum / 4;
    int[] memo = new int[(1 << matchsticks.length) - 1];
    return makeSquare(matchsticks, 0, 0, 0, targetLen, memo);
  }

  private int sum(int[] matchsticks) {
    return Arrays.stream(matchsticks).sum();
  }

  private boolean makeSquare(int[] matchsticks, int usedSticks, int matchedSides, int currentSideLen, int targetSideLen, int[] memo) {
    if (currentSideLen == targetSideLen) {
      matchedSides++;
      currentSideLen = 0;
    }

    if (matchedSides == 3) {
      memo[usedSticks] = 1;
      return true;
    }
    if (memo[usedSticks] != 0) {
      return memo[usedSticks] == 1;
    }

    for (int i = matchsticks.length - 1; i >= 0; i--) {
      if (isUsed(usedSticks, i) || matchsticks[i] + currentSideLen > targetSideLen) {
        continue;
      }

      boolean matched = makeSquare(matchsticks, markUsed(usedSticks, i), matchedSides, currentSideLen + matchsticks[i], targetSideLen, memo);
      if (matched) {
        memo[usedSticks] = 1;
        return true;
      }
    }
    memo[usedSticks] = -1;
    return false;
  }

  private boolean isUsed(int usedSticks, int i) {
    int bitPos = 1 << i;
    return (usedSticks & bitPos) > 0;
  }

  private int markUsed(int usedSticks, int index) {
    int bitPos = 1 << index;
    return usedSticks | bitPos;
  }
}

class LC0473OptimizedDfsSolution {
  public boolean makeSquare(int[] matchsticks) {
    int sum = sum(matchsticks);
    if (sum % 4 != 0) {
      return false;
    }

    Arrays.sort(matchsticks);

    int targetLen = sum / 4;
    boolean[] isStickUsed = new boolean[matchsticks.length];
    return makeSquare(matchsticks, isStickUsed, matchsticks.length - 1, 0, 0, targetLen);
  }

  private int sum(int[] matchsticks) {
    return Arrays.stream(matchsticks).sum();
  }

  private boolean makeSquare(int[] matchsticks, boolean[] isStickUsed, int index, int matchedSides,
                             int currentSideLen, int targetSideLen) {
    if (currentSideLen == targetSideLen) {
      matchedSides++;
      currentSideLen = 0;
      index = matchsticks.length - 1;;
    }

    if (matchedSides == 3) {
      return true;
    }

    for (int i = index; i >= 0; i--) {
      if (isStickUsed[i] || matchsticks[i] + currentSideLen > targetSideLen) {
        continue;
      }

      if (i != index && matchsticks[i] == matchsticks[i + 1] && !isStickUsed[i + 1]) {
        continue;
      }

      isStickUsed[i] = true;
      boolean matched = makeSquare(matchsticks, isStickUsed, i, matchedSides, currentSideLen + matchsticks[i], targetSideLen);
      isStickUsed[i] = false;
      if (matched) {
        return true;
      }
    }

    return false;
  }
}

class LC0473DpTabulationSolution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int len = nums.length;

    int sum = Arrays.stream(nums).sum();
    if (sum % k != 0) {
      return false;
    }
    int target = sum / k;

    int bitMaskLen = 1 << len;

    int[] bitMaskTable = new int[bitMaskLen];
    Arrays.fill(bitMaskTable, -1);

    bitMaskTable[0] = 0;

    for (int bitMask = 0; bitMask < bitMaskLen; bitMask++) {
      if (bitMaskTable[bitMask] == -1) {
        continue;
      }
      for (int j = 0; j < nums.length; j++) {
        int num = nums[j];
        int newBitMask = bitMask | (1 << j);
        if (bitMaskTable[newBitMask] != -1) {
          continue;
        }
        int nextSum = bitMaskTable[bitMask] + num;
        if (nextSum > target) {
          continue;
        }
        bitMaskTable[newBitMask] = nextSum % target;
        if (bitMaskTable[bitMaskLen - 1] == 0) {
          return true;
        }
      }
    }
    return bitMaskTable[bitMaskLen - 1] == 0;
  }
}