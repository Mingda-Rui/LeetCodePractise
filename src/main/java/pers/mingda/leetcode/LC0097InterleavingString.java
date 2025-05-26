package pers.mingda.leetcode;

public class LC0097InterleavingString {
  public boolean isInterleave(String s1, String s2, String s3) {
    boolean[][] invalidMemo = new boolean[s1.length() + 1][s2.length() + 1];
    return interleave(s1, 0, s2, 0, s3, 0, invalidMemo);
  }

  private boolean interleave(
      String s1, int i1, String s2, int i2, String s3, int i3, boolean[][] invalidMemo) {
    if (invalidMemo[i1][i2]) {
      return false;
    }

    if (i3 == s3.length()) {
      invalidMemo[i1][i2] = !(i1 == s1.length() && i2 == s2.length());
      return !invalidMemo[i1][i2];
    }

    if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
      if (interleave(s1, i1 + 1, s2, i2, s3, i3 + 1, invalidMemo)) {
        return true;
      }
    }
    if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
      if (interleave(s1, i1, s2, i2 + 1, s3, i3 + 1, invalidMemo)) {
        return true;
      }
    }
    invalidMemo[i1][i2] = true;
    return false;
  }

  public boolean isInterleave1DimensionalDp(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }
    boolean[] dp = new boolean[s2.length() + 1];
    dp[0] = true;
    for (int i = 0; i <= s1.length(); i++) {
      int index1 = i - 1;
      for (int j = 0; j <= s2.length(); j++) {
        int index2 = j - 1;
        int index3 = index1 + index2 + 1;
        if (index3 < 0) {
          continue;
        }
        dp[j] = index1 >= 0 && s1.charAt(index1) == s3.charAt(index3) && dp[j];
        dp[j] |= index2 >= 0 && s2.charAt(index2) == s3.charAt(index3) && dp[j - 1];
      }
    }
    return dp[s2.length()];
  }
}
