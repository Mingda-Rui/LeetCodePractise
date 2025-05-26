package pers.mingda.leetcode;

import java.util.Stack;

public class LC0456OneThreeTwoPattern {
  public boolean find132patternStack(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int third = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      int first = nums[i];
      if (first < third) return true;
      while (!stack.isEmpty() && first > stack.peek()) third = stack.pop();
      int second = first;
      stack.push(second);
    }
    return false;
  }
}
