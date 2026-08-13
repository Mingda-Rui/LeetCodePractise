package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC4014MinimumTotalPriceAfterApplyingDiscounts {}

class LC4014Solution {
  public double minPrice(int[] prices, int[] discounts) {
    double result = 0;
    List<Integer> pList = Arrays.stream(prices).boxed().sorted(Comparator.reverseOrder()).toList();
    List<Integer> pDiscounts =
        Arrays.stream(discounts).boxed().sorted(Comparator.reverseOrder()).toList();
    for (int i = 0; i < pList.size(); i++) {
      double dPrice = pList.get(i);
      double dDiscount = i < pDiscounts.size() ? ((100d - (double) pDiscounts.get(i)) / 100d) : 1d;
      result += (dPrice * dDiscount);
    }
    return result;
  }
}
