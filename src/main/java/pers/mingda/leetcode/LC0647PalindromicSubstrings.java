package pers.mingda.leetcode;

public class LC0647PalindromicSubstrings {
  public int countSubstrings(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result += countPalindromicSubstrings(s, i, i);
      result += countPalindromicSubstrings(s, i, i + 1);
    }
    return result;
  }

  private int countPalindromicSubstrings(String s, int left, int right) {
    int result = 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      result++;
      left--;
      right++;
    }
    return result;
  }
}
