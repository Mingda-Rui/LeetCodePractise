package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC2336SmallestNumberInInfiniteSet {}

class SmallestInfiniteSet {

  private int infinitHead;
  private Queue<Integer> addedBackQueue;

  public SmallestInfiniteSet() {
    this.infinitHead = 1;
    this.addedBackQueue = new PriorityQueue<>();
  }

  public int popSmallest() {
    if (addedBackQueue.isEmpty()) {
      int currentHead = infinitHead;
      infinitHead++;
      return currentHead;
    }
    int smallest = addedBackQueue.poll();
    while (!addedBackQueue.isEmpty() && addedBackQueue.peek() == smallest) {
      addedBackQueue.poll();
    }
    return smallest;
  }

  public void addBack(int num) {
    if (num < infinitHead) {
      addedBackQueue.offer(num);
    }
  }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such: SmallestInfiniteSet obj
 * = new SmallestInfiniteSet(); int param_1 = obj.popSmallest(); obj.addBack(num);
 */
