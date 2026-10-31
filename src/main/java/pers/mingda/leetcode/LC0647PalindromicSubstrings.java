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

class LC0647ManacherSolution {
  public int countSubstrings(String s) {
    int result = s.length();

    StringBuilder sPrime = new StringBuilder();
    sPrime.append("#");
    for (char c : s.toCharArray()) {
      sPrime.append(c).append("#");
    }

    int n = sPrime.length();
    int[] radius = new int[n];
    int center = 0;
    int rightBoundary = 0;

    for (int i = 0; i < n; i++) {
      if (i < rightBoundary) {
        int mirror = 2 * center - i;
        radius[i] = Math.min(radius[mirror], rightBoundary - i);
      }

      while (canExpandPan(sPrime, radius, i)) {
        radius[i]++;
      }

      if (i + radius[i] > rightBoundary) {
        rightBoundary = i + radius[i];
        center = i;
      }
    }

    // aba -> #a#b#a#
    // abba -> #a#b#b#a#
    for (int j : radius) {
      result += j / 2;
    }
    return result;
  }

  private boolean canExpandPan(StringBuilder sb, int[] radius, int index) {
    int leftIndex = index - radius[index] - 1;
    int rightIndex = index + radius[index] + 1;
    if (outOfBoundary(sb, leftIndex) || outOfBoundary(sb, rightIndex)) {
      return false;
    }
    return sb.charAt(leftIndex) == sb.charAt(rightIndex);
  }

  private boolean outOfBoundary(StringBuilder sb, int index) {
    return index < 0 || index >= sb.length();
  }
}