package pers.mingda.leetcode;

import java.util.Arrays;

public class L0274HIndex {}

class LC0274Solution {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int hIndex = 0;
    for (int i = citations.length - 1; i >= 0; i--) {
      int cite = citations[i];
      if (cite >= hIndex + 1) {
        hIndex++;
      } else {
        return hIndex;
      }
    }

    return hIndex;
  }
}
