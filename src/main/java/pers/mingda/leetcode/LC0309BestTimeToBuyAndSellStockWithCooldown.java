package pers.mingda.leetcode;

public class LC0309BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[] sellProfit = new int[prices.length];
        int currentBuyingIndex = 0;
        for (int i = 1; i < sellProfit.length; i++) {
            int val = prices[i];
            if (val <= prices[i - 1]) { // what about <=
                currentBuyingIndex = i;
                sellProfit[i] = sellProfit[i - 1];
            } else {
                int prevSellProfit = currentBuyingIndex - 2 >= 0 ? sellProfit[currentBuyingIndex - 2] : 0;
                int profitIfSell = prevSellProfit + val - prices[currentBuyingIndex];
                sellProfit[i] = Math.max(profitIfSell, sellProfit[i - 1]);
            }
        }
        return sellProfit[sellProfit.length - 1];
    }
}
