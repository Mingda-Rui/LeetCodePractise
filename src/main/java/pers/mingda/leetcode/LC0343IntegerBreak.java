package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0343IntegerBreak {
}

class LC0343Solution {
  public int integerBreak(int n) {
    Map<Integer, Integer> maxProductMap = new HashMap<>();
    int maxProduct = 0;
    for (int n1 = 1; n1 <= n / 2; n1++) {
      int n2 = n - n1;
      int product = getMaxProduct(n1, maxProductMap) * getMaxProduct(n2, maxProductMap);
      maxProduct = Math.max(maxProduct, product);
    }
    return maxProduct;
  }

  private int getMaxProduct(int n, Map<Integer, Integer> maxProductMap) {
    if (maxProductMap.containsKey(n)) {
      return maxProductMap.get(n);
    }
    if (n == 1) {
      return n;
    }
    int maxProduct = n;
    for (int p = 1; p < n; p++) {
      int product = p * getMaxProduct(n - p, maxProductMap);
      maxProduct = Math.max(maxProduct, product);
    }
    maxProductMap.put(n, maxProduct);
    return maxProduct;
  }
}
