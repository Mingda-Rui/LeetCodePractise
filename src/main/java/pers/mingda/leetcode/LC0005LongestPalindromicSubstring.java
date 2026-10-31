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
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}

class LC0005ManacherSolution {
  public String longestPalindrome(String s) {
    StringBuilder primedS = new StringBuilder();
    primedS.append("#");
    for (char c : s.toCharArray()) {
      primedS.append(c).append("#");
    }

    int n = primedS.length();

    int[] radius = new int[n];
    int center = 0;
    int rightBoundary = 0;
    for (int i = 0; i < n; i++) {
      if (i < rightBoundary) {
        int mirror = 2 * center - i;
        radius[i] = Math.min(radius[mirror], rightBoundary - i);
      }
      while (isCharEqual(primedS, i - radius[i] - 1, i + radius[i] +1)) {
        radius[i]++;
      }
      if (i + radius[i] > rightBoundary) {
        rightBoundary = i + radius[i];
        center = i;
      }
    }

    int maxLength = 0;
    int start = 0;
    for (int i = 0; i < radius.length; i++) {
      if (radius[i] > maxLength) {
        maxLength = radius[i];
        start = (i / 2) - (maxLength / 2);
      }
    }
    return s.substring(start, start + maxLength);
  }

  private boolean isCharEqual(StringBuilder sb, int index1, int index2) {
    if (outOfBoundary(sb, index1) || outOfBoundary(sb, index2)) {
      return false;
    }
    return sb.charAt(index1) == sb.charAt(index2);
  }

  private boolean outOfBoundary(StringBuilder sb, int index) {
    return index < 0 || index >= sb.length();
  }
}
