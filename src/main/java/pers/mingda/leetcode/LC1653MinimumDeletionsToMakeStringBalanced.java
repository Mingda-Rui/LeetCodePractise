package pers.mingda.leetcode;

public class LC1653MinimumDeletionsToMakeStringBalanced {
}

class LC1653Solution {
  public int minimumDeletions(String s) {
    int[] leftBs = new int[s.length()];
    int[] rightAs = new int[s.length()];

    int bCounter = 0;
    for (int i = 0; i < s.length(); i++) {
      leftBs[i] = bCounter;
      if (s.charAt(i) == 'b') {
        bCounter++;
      }
    }

    int aCounter = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      rightAs[i] = aCounter;
      if (s.charAt(i) == 'a') {
        aCounter++;
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      min = Math.min(min, leftBs[i] + rightAs[i]);
    }
    return min;
  }
}