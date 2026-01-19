package pers.mingda.leetcode;

import java.util.LinkedList;

public class LC0622DesignCircularQueue {}

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

class LC0622MyCircularQueueArraySolution {

  private final int[] array;
  private final int capacity;
  private int head;
  private int size;

  public LC0622MyCircularQueueArraySolution(int k) {
    this.array = new int[k];
    this.capacity = k;
    this.head = 0;
    this.size = 0;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    size++;
    int tail = getTail();
    array[tail] = value;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    head = (head + 1) % capacity;
    size--;
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return array[head];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    int tail = getTail();
    return array[tail];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  private int getTail() {
    return (head + size - 1) % capacity;
  }
}
