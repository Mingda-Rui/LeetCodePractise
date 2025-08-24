package pers.mingda.leetcode;

public class LC1180CountSubstringsWithOnlyOneDistinctLetter {}

class LC1180Solution {

  public int countLetters(String s) {
    int result = 0;
    for (int windowSize = 1; windowSize <= s.length(); windowSize++) {
      int[] letterCount = new int[26];
      for (int i = 0; i < s.length(); i++) {
        letterCount[s.charAt(i) - 'a']++;
        int prevHead = i - windowSize;
        if (prevHead >= 0) {
          letterCount[s.charAt(prevHead) - 'a']--;
        }
        if (i >= windowSize - 1 && countDistinctLetters(letterCount) == 1) {
          result++;
        }
      }
    }
    return result;
  }

  private int countDistinctLetters(int[] letterCount) {
    int distinctCount = 0;
    for (int count : letterCount) {
      if (count > 0) {
        distinctCount++;
      }
    }
    return distinctCount;
  }
}
