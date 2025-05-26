package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0004MedianOfTwoSortedArrays {}

class LC0004Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    Queue<Integer> lowerQueue = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> higherQueue = new PriorityQueue<>();
    enqueue(nums1, lowerQueue, higherQueue);
    enqueue(nums2, lowerQueue, higherQueue);
    if (lowerQueue.size() == higherQueue.size()) {
      return ((double) lowerQueue.remove() + (double) higherQueue.remove()) / 2;
    }
    return (double) lowerQueue.remove();
  }

  private void enqueue(int[] nums, Queue<Integer> lowerQueue, Queue<Integer> higherQueue) {
    for (int num : nums) {
      if (lowerQueue.size() == higherQueue.size()) {
        higherQueue.offer(num);
        int tmp = higherQueue.remove();
        lowerQueue.offer(tmp);
      } else {
        lowerQueue.offer(num);
        int tmp = lowerQueue.remove();
        higherQueue.offer(tmp);
      }
    }
  }
}
