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
            if (removeIndex >= 0 && deque.peekFirst() == nums[removeIndex])
                deque.pollFirst();

            while (!deque.isEmpty() && deque.peekLast() < val)
                deque.pollLast();
            deque.offerLast(val);
            int index = Math.max(0, i - (t - 1));
            result[index] = deque.peekFirst();
        }

        return result;
    }
}
