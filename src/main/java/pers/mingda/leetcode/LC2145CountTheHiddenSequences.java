package pers.mingda.leetcode;

public class LC2145CountTheHiddenSequences {}

class LC2145Solution {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    long offset = 0;
    long maxOffset = offset;
    long minOffset = offset;

    for (int diff : differences) {
      offset += diff;
      maxOffset = Math.max(maxOffset, offset);
      minOffset = Math.min(minOffset, offset);
    }
    long range = maxOffset - minOffset;
    return Math.max(0, (int) ((upper - lower) - range + 1));
  }
}
