package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Your MaxStack object will be instantiated and called as such: MaxStack obj = new MaxStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); int param_4 = obj.peekMax(); int
 * param_5 = obj.popMax();
 */
public class LC0716MaxStack {}

class LC0716MaxStackMaxHeapAndStackSolution {

  private final Stack<StackObject> stack;
  private final PriorityQueue<StackObject> maxHeap;
  private int counter;

  public LC0716MaxStackMaxHeapAndStackSolution() {
    this.counter = 0;
    this.stack = new Stack<>();
    Comparator<StackObject> comparator =
        (so1, so2) -> {
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
    while (!stack.isEmpty() && stack.peek().isRemoved) {
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

/**
 * Your MaxStack object will be instantiated and called as such: MaxStack obj = new MaxStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); int param_4 = obj.peekMax(); int
 * param_5 = obj.popMax();
 */
class LC0716MaxStackTwoTreeSetsSolution {

  private final TreeSet<LC0716NumVal> stack;
  private final TreeSet<LC0716NumVal> maxHeap;
  private int counter;

  public LC0716MaxStackTwoTreeSetsSolution() {
    this.stack = new TreeSet<>(Comparator.comparingInt(LC0716NumVal::number));
    Comparator<LC0716NumVal> maxHeapComparator =
        (nv1, nv2) -> {
          if (nv1.val() != nv2.val()) {
            return nv1.val() - nv2.val();
          }
          return nv1.number() - nv2.number();
        };
    this.maxHeap = new TreeSet<>(maxHeapComparator);
    this.counter = 0;
  }

  public void push(int x) {
    LC0716NumVal nv = new LC0716NumVal(counter, x);
    counter++;
    stack.add(nv);
    maxHeap.add(nv);
  }

  public int pop() {
    LC0716NumVal nv = stack.pollLast();
    if (nv == null) {
      return -1;
    }
    maxHeap.remove(nv);
    return nv.val();
  }

  public int top() {
    return stack.last().val();
  }

  public int peekMax() {
    return maxHeap.last().val();
  }

  public int popMax() {
    LC0716NumVal nv = maxHeap.pollLast();
    if (nv == null) {
      return -1;
    }
    stack.remove(nv);
    return nv.val();
  }
}

record LC0716NumVal(int number, int val) {}
