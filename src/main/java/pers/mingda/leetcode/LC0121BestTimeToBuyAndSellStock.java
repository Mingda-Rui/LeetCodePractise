package pers.mingda.leetcode;

public class LC0121BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;
    for (int price : prices) {
      maxProfit = Math.max(maxProfit, price - minPrice);
      minPrice = Math.min(minPrice, price);
    }
    return Math.max(0, maxProfit);
  }
}
