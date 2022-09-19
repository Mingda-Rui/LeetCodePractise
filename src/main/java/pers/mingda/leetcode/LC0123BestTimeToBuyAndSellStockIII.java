package pers.mingda.leetcode;

public class LC0123BestTimeToBuyAndSellStockIII {

}

class Solution {
    public int maxProfit(int[] prices) {
        int[] leftMaxProfit = new int[prices.length];
        int[] rightMaxProfit = new int[prices.length];

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            leftMaxProfit[i] = maxProfit;
        }

        int maxPrice = Integer.MIN_VALUE;
        maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            maxPrice = Math.max(maxPrice, price);
            int profit = maxPrice - price;
            maxProfit = Math.max(maxProfit, profit);
            rightMaxProfit[i] = maxProfit;
        }

        int maxProfitTwoTrans = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int profit = leftMaxProfit[i] + rightMaxProfit[i];
            maxProfitTwoTrans = Math.max(maxProfitTwoTrans, profit);
        }
        return maxProfitTwoTrans;
    }
}
