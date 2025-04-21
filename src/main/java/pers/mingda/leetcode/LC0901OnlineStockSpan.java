package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0901OnlineStockSpan {
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {

    List<Integer> prices;

    public StockSpanner() {
        this.prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int count = 0;
        for (int i = prices.size() - 1; i >= 0; i--) {
            if (prices.get(i) <= price) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
