package pers.mingda.leetcode;

public class LC0714BestTimeToBuyAndSellStockWithTransactionFee {}

class LC0714Solution {

  public int maxProfit(int[] prices, int fee) {
    int maxFree = 0;
    int maxHold = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      int nextFree = Math.max(maxFree, maxHold + prices[i] - fee);
      int nextHold = Math.max(maxHold, maxFree - prices[i]);
      maxFree = nextFree;
      maxHold = nextHold;
    }
    return maxFree;
  }
}
