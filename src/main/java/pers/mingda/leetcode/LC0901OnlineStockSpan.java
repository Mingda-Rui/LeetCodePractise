package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC0901OnlineStockSpan {
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {

    Stack<Integer> stack;
    List<Integer> counter;

    public StockSpanner() {
        stack = new Stack<>();
        counter = new ArrayList<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek() <= price) {
            stack.pop();
            count += counter.removeLast();
        }
        stack.push(price);
        counter.add(count);
        return count;
    }
}
