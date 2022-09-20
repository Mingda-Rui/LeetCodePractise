package pers.mingda.leetcode;

public class LC0188BestTimeToBuyAndSellStockIV {

}

class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
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
}