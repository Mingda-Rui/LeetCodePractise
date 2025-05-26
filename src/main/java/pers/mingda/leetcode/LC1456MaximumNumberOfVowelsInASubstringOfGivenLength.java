package pers.mingda.leetcode;

import java.util.Set;

public class LC1456MaximumNumberOfVowelsInASubstringOfGivenLength {
  public int maxVowels(String s, int k) {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    int tail = 0;
    int currentCount = 0;
    int maxCount = 0;
    for (int head = 0; head < s.length(); head++) {
      if (maxCount == k) {
        return maxCount;
      }
      if (isVowel(s.charAt(head), vowels)) {
        currentCount++;
      }
      if (head - tail >= k) {
        if (isVowel(s.charAt(tail), vowels)) {
          currentCount--;
        }
        tail++;
      }
      maxCount = Math.max(maxCount, currentCount);
    }
    return maxCount;
  }

  private boolean isVowel(char c, Set<Character> vowels) {
    return vowels.contains(c);
  }
}
