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

class LC0739DailyTemperaturesArraySolution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    int maxTemp = temperatures[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (temperatures[i] >= maxTemp) {
        maxTemp = temperatures[i];
        continue;
      }
      int pointer = i + 1;
      while (pointer < n && temperatures[i] >= temperatures[pointer]) {
        pointer += result[pointer];
      }
      result[i] = pointer - i;
    }
    return result;
  }
}