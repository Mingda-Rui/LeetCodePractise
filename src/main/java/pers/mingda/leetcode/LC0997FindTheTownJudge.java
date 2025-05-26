package pers.mingda.leetcode;

public class LC0997FindTheTownJudge {
  public int findJudge(int n, int[][] trust) {
    if (trust.length < n - 1) {
      return -1;
    }
    int[] trustRecord = new int[n + 1];
    for (int[] trustRelation : trust) {
      int person = trustRelation[0];
      int trustee = trustRelation[1];
      trustRecord[person]--;
      trustRecord[trustee]++;
    }
    for (int i = 1; i <= n; i++) {
      if (trustRecord[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }
}
