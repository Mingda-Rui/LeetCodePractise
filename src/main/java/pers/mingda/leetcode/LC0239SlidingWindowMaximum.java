package pers.mingda.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC0239SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int t) {
    int size = nums.length - (t - 1);
    int[] result = new int[size];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      int removeIndex = i - t;
      if (
        removeIndex >= 0 && deque.peekFirst() == nums[removeIndex]
      ) deque.pollFirst();

      while (!deque.isEmpty() && deque.peekLast() < val) deque.pollLast();
      deque.offerLast(val);
      int index = Math.max(0, i - (t - 1));
      result[index] = deque.peekFirst();
    }

    return result;
  }

  public int[] maxSlidingWindowDp(int[] nums, int t) {
    int[] result = new int[nums.length - (t - 1)];
    int[] leftMax = new int[nums.length];
    int[] rightMax = new int[nums.length];

    int currentMax = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      if (i % t == 0) currentMax = Integer.MIN_VALUE;
      currentMax = Math.max(val, currentMax);
      leftMax[i] = currentMax;
    }

    currentMax = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
      int val = nums[i];
      if (i % t == t - 1) currentMax = Integer.MIN_VALUE;
      currentMax = Math.max(val, currentMax);
      rightMax[i] = currentMax;
    }

    for (int r = 0; r < nums.length - (t - 1); r++) {
      int l = r + (t - 1);
      result[r] = Math.max(rightMax[r], leftMax[l]);
    }
    return result;
  }
}
