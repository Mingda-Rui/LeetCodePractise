package pers.mingda.leetcode;

public class LC1143LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] record = new int[text1.length()][text2.length()];
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          int prev = (i == 0 || j == 0) ? 0 : record[i - 1][j - 1];
          record[i][j] = prev + 1;
        } else {
          int top = i == 0 ? 0 : record[i - 1][j];
          int left = j == 0 ? 0 : record[i][j - 1];
          record[i][j] = Math.max(top, left);
        }
      }
    }
    return record[text1.length() - 1][text2.length() - 1];
  }
}
