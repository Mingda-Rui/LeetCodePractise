package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0295FindMedianFromDataStream {}

class MedianFinder {
  private Queue<Integer> smallQueue;
  private Queue<Integer> bigQueue;

  public MedianFinder() {
    smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
    bigQueue = new PriorityQueue<>(Comparator.naturalOrder());
  }

  public void addNum(int num) {
    boolean isEven = smallQueue.size() == bigQueue.size();
    Queue<Integer> from = isEven ? bigQueue : smallQueue;
    Queue<Integer> to = isEven ? smallQueue : bigQueue;

    boolean needRebalance = !from.isEmpty() && (isEven ? num > from.peek() : num < from.peek());
    if (needRebalance) {
      from.offer(num);
      num = from.poll();
    }
    to.offer(num);
  }

  public double findMedian() {
    if (smallQueue.size() == bigQueue.size()) {
      double sum = smallQueue.peek() + bigQueue.peek();
      return sum / 2;
    }
    return smallQueue.peek();
  }
}
