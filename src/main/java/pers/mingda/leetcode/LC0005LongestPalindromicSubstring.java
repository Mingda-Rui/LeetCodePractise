package pers.mingda.leetcode;

public class LC0005LongestPalindromicSubstring {

  public String longestPalindromeBruteForce(String s) {
    int head = 0;
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      int oddLen = getLongest(s, i, i);
      int evenLen = getLongest(s, i, i + 1);
      int curLongest = Math.max(oddLen, evenLen);
      if (curLongest > len) {
        len = curLongest;
        head = i - (len - 1) / 2;
      }
    }
    return s.substring(head, head + len);
  }

  private int getLongest(String s, int left, int right) {
    while (
      left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
    ) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
