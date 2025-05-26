package pers.mingda.leetcode;

public class LC0028FindTheIndexOfTheFirstOccurrenceInAString {}

class LC0028Solution {

  public int strStr(String haystack, String needle) {
    // 0 1 2 3 4
    //       0 1
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (findNeedle(haystack, i, needle)) {
        return i;
      }
    }
    return -1;
  }

  private boolean findNeedle(String haystack, int index, String needle) {
    for (int i = 0; i < needle.length(); i++) {
      if (haystack.charAt(index + i) != needle.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
