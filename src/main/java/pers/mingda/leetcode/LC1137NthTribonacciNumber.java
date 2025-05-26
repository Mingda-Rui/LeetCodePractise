package pers.mingda.leetcode;

public class LC1137NthTribonacciNumber {

  public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 1;
    }
    int nLess1 = 1;
    int nLess2 = 1;
    int nLess3 = 0;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = nLess1 + nLess2 + nLess3;
      nLess3 = nLess2;
      nLess2 = nLess1;
      nLess1 = result;
    }
    return result;
  }
}
