package pers.mingda.leetcode;

import java.util.Stack;

public class LC0907SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        int currentTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > current) {
                int prevIndex = stack.pop();
                int prevPrevIndex = stack.isEmpty() ? -1 : stack.peek();
                int count = prevIndex - prevPrevIndex;
                currentTotal -= arr[prevIndex] * count;
                currentTotal += current * count;
            }
            stack.push(i);
            currentTotal += current;
            result += currentTotal;
        }
        if (result < Integer.MAX_VALUE) return (int) result;
        return (int) (result % 1000000007);
    }
}
