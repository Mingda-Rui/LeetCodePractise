package pers.mingda.leetcode;

public class LC1180CountSubstringsWithOnlyOneDistinctLetter {}

class LC1180Solution {

  public int countLetters(String s) {
    int currentHead = -1;
    char currentChar = ' ';
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != currentChar) {
        result += calcCombination(s, currentHead, i - 1);
        currentHead = i;
        currentChar = s.charAt(i);
      }
    }
    result += calcCombination(s, currentHead, s.length() - 1);
    return result;
  }

  private int calcCombination(String s, int start, int endInclusive) {
    if (start < 0 || endInclusive < start) {
      return 0;
    }
    int len = endInclusive - start + 1;
    return ((1 + len) * len) / 2;
  }
}
