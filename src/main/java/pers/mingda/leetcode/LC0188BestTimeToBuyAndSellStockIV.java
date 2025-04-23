package pers.mingda.leetcode;

public class LC0188BestTimeToBuyAndSellStockIV {}

class LC0188Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k * 2 >= len) return highFrequencyTrading(prices);
        int[][] record = new int[k + 1][len];

        for (int i = 1; i <= k; i++) {

            int maxProfit = 0;
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                int buy = prices[j];
                int prevMaxProfit = j > 0 ? record[i - 1][j - 1] : 0;
                minCost = Math.min(minCost, buy - prevMaxProfit);
                maxProfit = Math.max(maxProfit, buy - minCost);
                record[i][j] = maxProfit;
            }
        }
        return record[k][len - 1];
    }

    private int highFrequencyTrading(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevPrice = prices[i - 1];
            int profit = Math.max(0, prices[i] - prevPrice);
            maxProfit += profit;
        }
        return maxProfit;
    }
}