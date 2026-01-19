package pers.mingda.leetcode;

import java.util.LinkedList;

public class LC0622DesignCircularQueue {}

class LC0622MyCircularQueueLinkedListSolution {

  private final LinkedList<Integer> list;
  private final int capacity;

  public LC0622MyCircularQueueLinkedListSolution(int k) {
    this.capacity = k;
    this.list = new LinkedList<>();
  }

  public boolean enQueue(int value) {
    if (list.size() == capacity) {
      return false;
    }
    return list.add(value);
  }

  public boolean deQueue() {
    if (list.isEmpty()) {
      return false;
    }
    list.removeFirst();
    return true;
  }

  public int Front() {
    if (list.isEmpty()) {
      return -1;
    }
    return list.getFirst();
  }

  public int Rear() {
    if (list.isEmpty()) {
      return -1;
    }
    return list.getLast();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public boolean isFull() {
    return list.size() == capacity;
  }
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
