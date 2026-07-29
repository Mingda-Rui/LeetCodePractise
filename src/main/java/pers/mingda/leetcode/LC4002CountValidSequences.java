package pers.mingda.leetcode;

import java.math.BigInteger;

public class LC4002CountValidSequences {}

class LC4002Solution {

  int modulo = 1_000_000_007;

  public int countValidSequences(int n, int k) {
    if (n < k) {
      return 0;
    }

    int total = comb(n - 1, k - 1);
    int odd = 0;
    if ((n % 2 == 0 && k % 2 == 0) || (n % 2 != 0 && k % 2 != 0)) {
      int remaining = (n - k) / 2;
      odd = comb(remaining + k - 1, k - 1);
    }

    return (total - odd + modulo) % modulo;
  }

  private int comb(int n, int k) {
    return combination(n, k).mod(BigInteger.valueOf(modulo)).intValue();
  }

  public BigInteger combination(int n, int k) {
    if (k < 0 || k > n) {
      return BigInteger.ZERO;
    }

    k = Math.min(k, n - k);

    BigInteger result = BigInteger.ONE;

    for (int i = 1; i <= k; i++) {
      result = result
          .multiply(BigInteger.valueOf(n - k + i))
          .divide(BigInteger.valueOf(i));
    }

    return result;
  }
}