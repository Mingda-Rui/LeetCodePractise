package pers.mingda.leetcode;

import java.util.Stack;

public class LC0042TrappingRainWater {

  public int trap(int[] height) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < height.length; i++) {
      int currentH = height[i];
      while (!stack.isEmpty() && height[stack.peek()] < currentH) {
        int target = stack.pop();
        int left = stack.isEmpty() ? target : stack.peek();
        int minBoard = Math.min(height[left], currentH);
        int distance = i - left - 1;
        int capacity = (minBoard - height[target]) * distance;
        result += Math.max(0, capacity);
      }
      stack.push(i);
    }
    return result;
  }

  public int trapDpSolution(int[] height) {
    int leftHighest = 0;
    int[] leftHighests = new int[height.length];
    for (int i = 0; i < height.length; i++) {
      leftHighest = Math.max(leftHighest, height[i]);
      leftHighests[i] = leftHighest;
    }

    int rightHighest = 0;
    int[] rightHighests = new int[height.length];
    for (int i = height.length - 1; i >= 0; i--) {
      rightHighest = Math.max(rightHighest, height[i]);
      rightHighests[i] = rightHighest;
    }

    int result = 0;
    for (int i = 0; i < height.length; i++) {
      int maxCap = Math.min(leftHighests[i], rightHighests[i]);
      result += Math.max(maxCap - height[i], 0);
    }
    return result;
  }

  public int trapTwoPointers(int[] height) {
    int result = 0;
    int left = 0;
    int highestLeft = 0;
    int right = height.length - 1;
    int highestRight = 0;
    while (left < right) {
      highestLeft = Math.max(highestLeft, height[left]);
      highestRight = Math.max(highestRight, height[right]);
      if (highestLeft < highestRight) {
        result += Math.max(highestLeft - height[left], 0);
        left++;
      } else {
        result += Math.max(highestRight - height[right], 0);
        right--;
      }
    }
    return result;
  }
}
