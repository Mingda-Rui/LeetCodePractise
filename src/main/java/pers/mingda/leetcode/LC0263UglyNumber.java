package pers.mingda.leetcode;

public class LC0263UglyNumber {

  public boolean isUgly(int n) {
    if (n <= 0) return false;
    n = deepDivideBy(n, 2);
    n = deepDivideBy(n, 3);
    n = deepDivideBy(n, 5);
    return n == 1;
  }

  private int deepDivideBy(int dividend, int divisor) {
    while (dividend % divisor == 0) dividend /= divisor;
    return dividend;
  }
}
