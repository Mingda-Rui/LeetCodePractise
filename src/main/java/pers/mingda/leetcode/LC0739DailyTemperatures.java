package pers.mingda.leetcode;

import java.util.Stack;

public class LC0739DailyTemperatures {
}

class LC0739DailyTemperaturesMonotonicStackSolution {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int prevDay = stack.pop();
        result[prevDay] = i - prevDay;
      }
      stack.push(i);
    }
    return result;
  }
}
