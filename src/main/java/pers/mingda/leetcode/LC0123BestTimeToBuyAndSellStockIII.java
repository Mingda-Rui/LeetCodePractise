package pers.mingda.leetcode;

public class LC0123BestTimeToBuyAndSellStockIII {

}

class LC0123Solution {
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

class SpaceComplexityO1Solution {
    public int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE;
        int maxProfit1 = 0;

        int minPrice2 = Integer.MAX_VALUE;
        int maxProfit2 = 0;

        for (int price: prices) {
            minPrice1 = Math.min(minPrice1, price);
            int profit1 = price - minPrice1;
            maxProfit1 = Math.max(maxProfit1, profit1);

            int price2 = price - maxProfit1;
            minPrice2 = Math.min(minPrice2, price2);
            int profit2 = price - minPrice2;
            maxProfit2 = Math.max(maxProfit2, profit2);
        }

        return maxProfit2;
    }
}