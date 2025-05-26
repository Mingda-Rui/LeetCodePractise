package pers.mingda.leetcode;

public class LC1732FindTheHighestAltitude {
  public int largestAltitude(int[] gain) {
    int highest = 0;
    int current = 0;
    for (int netGain : gain) {
      current += netGain;
      highest = Math.max(current, highest);
    }
    return highest;
  }
}
