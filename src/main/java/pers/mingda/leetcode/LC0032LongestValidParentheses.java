package pers.mingda.leetcode;

public class LC0032LongestValidParentheses {}

class LC0032Solution {

  public int longestValidParentheses(String s) {
    int[] dp = new int[s.length()];
    int max = 0;
    for (int i = 1; i < s.length(); i++) {
      char current = s.charAt(i);
      if (current == '(') {
        continue;
      }

      if (s.charAt(i - 1) == '(') {
        dp[i] = getLongestAt(dp, i - 2) + 2;
      } else {
        int prevLongest = dp[i - 1];
        int endBeforePrevL = i - prevLongest - 1;
        if (endBeforePrevL < 0 || s.charAt(endBeforePrevL) != '(') {
          continue;
        }
        int prevPrevLongest = getLongestAt(dp, endBeforePrevL - 1);
        dp[i] = prevPrevLongest + prevLongest + 2;
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  private int getLongestAt(int[] dp, int index) {
    if (index < 0) {
      return 0;
    }
    return dp[index];
  }
}
