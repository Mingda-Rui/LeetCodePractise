package pers.mingda.leetcode;

public class LC0172FactorialTrailingZeroes {}

class Solution {

  public int trailingZeroes(int n) {
    int count = 0;
    for (int i = 5; i <= n; i += 5) {
      count += countPowerOfFive(i);
    }
    return count;
  }

  private int countPowerOfFive(int num) {
    int count = 0;
    while (num % 5 == 0) {
      count++;
      num /= 5;
    }
    return count;
  }
}
