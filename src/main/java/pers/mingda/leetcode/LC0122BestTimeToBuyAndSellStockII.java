package pers.mingda.leetcode;

public class LC0122BestTimeToBuyAndSellStockII {

}

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int pointer = 0;
        while (pointer < prices.length) {
            while (pointer + 1 < prices.length && prices[pointer] > prices[pointer + 1])
                pointer ++;
            int buyPrice = prices[pointer];

            while (pointer + 1 < prices.length && prices[pointer] < prices[pointer + 1])
                pointer++;
            int sellPrice = prices[pointer];

            result += (sellPrice - buyPrice);
            pointer++;
        }
        return result;
    }
}
