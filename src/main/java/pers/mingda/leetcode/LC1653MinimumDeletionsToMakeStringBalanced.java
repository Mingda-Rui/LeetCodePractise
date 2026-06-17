package pers.mingda.leetcode;

public class LC1653MinimumDeletionsToMakeStringBalanced {}

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
    int min = Integer.MAX_VALUE;
    for (int i = s.length() - 1; i >= 0; i--) {

      min = Math.min(min, leftBs[i] + aCounter);
      if (s.charAt(i) == 'a') {
        aCounter++;
      }
    }
    return min;
  }
}

class LC1653TwoVariablesSolution {
  public int minimumDeletions(String s) {
    int bCounter = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'b') {
        bCounter++;
      }
    }

    int aCounter = 0;
    int min = Integer.MAX_VALUE;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == 'b') {
        bCounter--;
      }

      min = Math.min(min, bCounter + aCounter);
      if (s.charAt(i) == 'a') {
        aCounter++;
      }
    }
    return min;
  }
}

class LC1653StackSolution {
  public int minimumDeletions(String s) {
    int bCounter = 0;
    int result = 0;
    for (char c : s.toCharArray()) {
      if (c == 'b') {
        bCounter++;
      } else if (bCounter != 0) {
        bCounter--;
        result++;
      }
    }
    return result;
  }
}
