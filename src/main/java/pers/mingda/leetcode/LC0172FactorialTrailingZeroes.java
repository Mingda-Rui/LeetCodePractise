package pers.mingda.leetcode;

public class LC0172FactorialTrailingZeroes {}

class Solution {

  public int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
      count += n / 5;
      n /= 5;
    }
    return count;
  }
}
