package pers.mingda.leetcode;

public class LC0050PowXN {
  public double myPow(double x, int n) {
    return binaryExp(x, (long) n);
  }

  private double binaryExp(double x, double n) {
    if (n < 0) {
      n = -n;
      x = 1 / x;
    }

    double result = 1;
    while (n != 0) {
      if (n % 2 == 0) {
        n /= 2;
        x *= x;
      } else {
        n -= 1;
        result *= x;
      }
    }
    return result;
  }
}
