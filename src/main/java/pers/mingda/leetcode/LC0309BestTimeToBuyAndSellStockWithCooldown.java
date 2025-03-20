package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0309BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] profits = new int[len][len];
        initProfits(profits);
        int[] startDateProfits = new int[len];
        Arrays.fill(startDateProfits, -1);
        int[] anchoredStartDateP = new int[len];
        Arrays.fill(anchoredStartDateP, -1);
        return maxProfit(prices, profits, startDateProfits, anchoredStartDateP, 0);

    }

    private void initProfits(int[][] profits) {
        for (int[] profit : profits) {
            Arrays.fill(profit, -1);
        }
    }

    private int maxProfit(int[] prices, int[][] profits, int[] startDateProfits, int[] anchoredStartDateP, int startDate) {
        if (startDate >= startDateProfits.length) {
            return 0;
        }
        if (startDateProfits[startDate] != -1) {
            return startDateProfits[startDate];
        }
        int max = 0;
        for (int buy = startDate; buy < prices.length; buy++) {
            if (anchoredStartDateP[buy] != -1) {
                max = Math.max(max, anchoredStartDateP[buy]);
                continue;
            }
            int localMax = 0;
            for (int sell = buy + 1; sell < prices.length; sell++) {
                if (profits[buy][sell] == -1) {
                    int remainingProfit = maxProfit(prices, profits, startDateProfits, anchoredStartDateP, sell + 2);
                    profits[buy][sell] = prices[sell] - prices[buy] + remainingProfit;
                }
                max = Math.max(max, profits[buy][sell]);
                localMax = Math.max(localMax, profits[buy][sell]);
            }
            anchoredStartDateP[buy] = localMax;
        }
        startDateProfits[startDate] = max;
        return max;
    }
}
