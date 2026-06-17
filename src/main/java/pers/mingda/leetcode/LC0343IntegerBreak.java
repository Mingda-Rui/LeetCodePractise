package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0343IntegerBreak {}

class LC0343Solution {
  public int integerBreak(int n) {
    if (n <= 3) {
      return n - 1;
    }
    Map<Integer, Integer> maxProductMap = new HashMap<>();
    return getMaxProduct(n, maxProductMap);
  }

  private int getMaxProduct(int n, Map<Integer, Integer> maxProductMap) {
    if (maxProductMap.containsKey(n)) {
      return maxProductMap.get(n);
    }
    if (n <= 3) {
      return n;
    }
    int maxProduct = Integer.MIN_VALUE;
    for (int p = 1; p < n; p++) {
      int product = p * getMaxProduct(n - p, maxProductMap);
      maxProduct = Math.max(maxProduct, product);
    }
    maxProductMap.put(n, maxProduct);
    return maxProduct;
  }
}

class LC0343DpTabulationSolution {
  public int integerBreak(int n) {
    if (n <= 3) {
      return n - 1;
    }
    int[] memo = new int[n + 1];
    memo[1] = 1;
    memo[2] = 2;
    memo[3] = 3;
    for (int i = 4; i <= n; i++) {
      int max = Integer.MIN_VALUE;
      for (int num = 1; num < i; num++) {
        max = Math.max(max, num * memo[i - num]);
      }
      memo[i] = max;
    }
    return memo[n];
  }
}

class LC0343MathematicalSolution {
  public int integerBreak(int n) {
    if (n <= 3) {
      return n - 1;
    }
    int result = 1;
    while (n > 4) {
      n -= 3;
      result *= 3;
    }
    result *= n;

    return result;
  }
}

class LC0343EquationSolution {
  public int integerBreak(int n) {
    if (n <= 3) {
      return n - 1;
    }

    if (n % 3 == 0) {
      return (int) Math.pow(3, (double) n / 3);
    } else if (n % 3 == 1) {
      return (int) Math.pow(3, (double) n / 3 - 1) * 4;
    } else {
      return (int) Math.pow(3, (double) n / 3) * 2;
    }
  }
}
