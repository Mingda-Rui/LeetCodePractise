package pers.mingda.leetcode;

public class LC0309BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[] profitRecord = new int[prices.length];
        return calcProfit(prices, profitRecord, 0);
    }

    private int calcProfit(int[] prices, int[] profitRecord, int date) {
        // hold
        int holdProfit = date == 0 ? 0 : profitRecord[date - 1];

        // sell, iterate through buy days
        int sellProfit = 0;
        for (int sell = 0; sell < date; sell++) {
            int currentProfit = prices[date] - prices[sell];
            int prevProfit = sell >= 2 ? profitRecord[sell - 2] : 0;
            sellProfit = Math.max(sellProfit, currentProfit + prevProfit);
        }
        int max = Math.max(holdProfit, sellProfit);
        profitRecord[date] = max;
        if (date == prices.length - 1) {
            return max;
        }
        return calcProfit(prices, profitRecord, date + 1);
    }

    public int maxProfitStateMachine(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = Integer.MIN_VALUE;
        ;
        int idel = 0;
        for (int price : prices) {
            int prevSold = sold;
            sold = hold + price;
            hold = Math.max(hold, idel - price);
            idel = Math.max(idel, prevSold);
        }
        return Math.max(sold, idel);
    }
}
