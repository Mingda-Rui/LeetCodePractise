package pers.mingda.leetcode;

public class LC0714BestTimeToBuyAndSellStockWithTransactionFee {}

class LC0714Solution {

  public int maxProfit(int[] prices, int fee) {
    int[] free = new int[prices.length];
    int[] hold = new int[prices.length];

    hold[0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
      hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
    }
    return free[prices.length - 1];
  }
}
