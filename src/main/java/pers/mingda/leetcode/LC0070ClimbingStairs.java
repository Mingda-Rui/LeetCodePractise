package pers.mingda.leetcode;

public class LC0070ClimbingStairs {

  public int climbStairs(int n) {
    int[] record = new int[n + 1];
    for (int i = 1; i < n + 1; i++) if (i <= 2) record[i] = i;
    else record[i] = record[i - 1] + record[i - 2];
    return record[n];
  }
}
