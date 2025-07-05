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

class LC0028IterativeSolution {

  public int strStr(String haystack, String needle) {
    int[] lps = constructLps(needle);
    int nI = 0;
    int hI = 0;
    while (hI < haystack.length()) {
      if (haystack.charAt(hI) == needle.charAt(nI)) {
        nI++;
        hI++;
        if (nI == needle.length()) {
          return hI - needle.length();
        }
      } else if (nI == 0) {
        hI++;
      } else {
        nI = lps[nI - 1];
      }
    }
    return -1;
  }

  private int[] constructLps(String needle) {
    if (needle == null || needle.isEmpty()) {
      throw new IllegalArgumentException("Needle can not be null or empty");
    }
    int[] lps = new int[needle.length()];
    if (needle.length() == 1) {
      return lps;
    }
    int head = 0;
    int index = 1;
    while (index < needle.length()) {
      if (needle.charAt(head) == needle.charAt(index)) {
        head++;
        lps[index] = head;
        index++;
      } else if (head == 0) {
        index++;
      } else {
        head = lps[head - 1];
      }
    }
    return lps;
  }
}
