package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0343IntegerBreak {
}

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