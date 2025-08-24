package pers.mingda.leetcode;

public class LC1180CountSubstringsWithOnlyOneDistinctLetter {}

class LC1180Solution {

  public int countLetters(String s) {
    int currentHead = 0;
    int result = 0;
    for (int i = 0; i <= s.length(); i++) {
      if (i == s.length() || s.charAt(i) != s.charAt(currentHead)) {
        result += calcCombination(s, currentHead, i);
        currentHead = i;
      }
    }
    return result;
  }

  private int calcCombination(String s, int start, int endExclusive) {
    int len = endExclusive - start;
    return ((1 + len) * len) / 2;
  }
}

class LC1180DpSolution {

  public int countLetters(String s) {
    int sameLetterCount = 1;
    int result = 0;
    for (int i = 1; i <= s.length(); i++) {
      if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
        result += calcArithmeticSum(sameLetterCount);
        sameLetterCount = 1;
      } else if (s.charAt(i) == s.charAt(i - 1)) {
        sameLetterCount++;
      }
    }
    return result;
  }

  private int calcArithmeticSum(int num) {
    return ((1 + num) * num) / 2;
  }
}
