package pers.mingda.leetcode;

public class LC0125ValidPalindrome {
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left <= right && !isAlphnumeric(s.charAt(left))) left++;
      while (left <= right && !isAlphnumeric(s.charAt(right))) right--;
      if (left <= right && !isEqualsCaseInsensitive(s.charAt(left), s.charAt(right))) return false;

      left++;
      right--;
    }
    return true;
  }

  private boolean isAlphnumeric(char c) {
    if ('0' <= c && '9' >= c) return true;
    else if ('a' <= c && 'z' >= c) return true;
    else if ('A' <= c && 'Z' >= c) return true;

    return false;
  }

  private boolean isEqualsCaseInsensitive(char a, char b) {
    return Character.toLowerCase(a) == Character.toLowerCase(b);
  }

  public boolean isPalindromeRefactored(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (!isAlphnumeric(s.charAt(left))) left++;
      else if (!isAlphnumeric(s.charAt(right))) right--;
      else if (!isEqualsCaseInsensitive(s.charAt(left), s.charAt(right))) return false;
      else {
        left++;
        right--;
      }
    }
    return true;
  }
}
