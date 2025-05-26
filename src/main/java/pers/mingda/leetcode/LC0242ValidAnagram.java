package pers.mingda.leetcode;

public class LC0242ValidAnagram {
  public boolean isAnagramArraySolution(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] record = new int[128];
    for (char cInS : s.toCharArray()) record[cInS]++;
    for (char cInT : t.toCharArray()) {
      record[cInT]--;
      if (record[cInT] < 0) return false;
    }
    return true;
  }
}
