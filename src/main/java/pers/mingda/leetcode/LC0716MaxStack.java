package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

public class LC0716MaxStack {}

class LC0716MaxStackMaxHeapAndStackSolution {

  private int counter;
  private final Stack<StackObject> stack;
  private final PriorityQueue<StackObject> maxHeap;

  public LC0716MaxStackMaxHeapAndStackSolution() {
    this.counter = 0;
    this.stack = new Stack<>();
    Comparator<StackObject> comparator = (so1, so2) -> {
      if (so1.val != so2.val) {
        return so2.val - so1.val;
      }
      return so2.ts - so1.ts;
    };
    this.maxHeap = new PriorityQueue<>(comparator);
  }

  public void push(int x) {
    StackObject so = new StackObject(x, counter);
    counter++;
    stack.push(so);
    maxHeap.add(so);
  }

  public int pop() {
    flushRemovedFromStack();
    StackObject so = stack.pop();
    so.isRemoved = true;
    return so.val;
  }

  public int top() {
    flushRemovedFromStack();
    return stack.peek().val;
  }

  public int peekMax() {
    flushRemovedFromMaxHeap();
    return !maxHeap.isEmpty() ? maxHeap.peek().val : -1;
  }

  public int popMax() {
    flushRemovedFromMaxHeap();
    StackObject so = maxHeap.remove();
    so.isRemoved = true;
    return so.val;
  }

  private void flushRemovedFromStack() {
    while(!stack.isEmpty() && stack.peek().isRemoved) {
      stack.pop();
    }
  }

  private void flushRemovedFromMaxHeap() {
    while (!maxHeap.isEmpty() && maxHeap.peek().isRemoved) {
      maxHeap.remove();
    }
  }
}

class StackObject {
  int val;
  int ts;
  boolean isRemoved;

  public StackObject(int val, int ts) {
    this.val = val;
    this.ts = ts;
    this.isRemoved = false;
  }
}