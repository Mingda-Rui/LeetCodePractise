package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import java.util.EmptyStackException;

/** 3.1 Three in One: Describe how you could use a single array to implement three stacks. */
public class _3_1ThreeInOne {}

class FixedMultiStack {

  private int[] stack;
  private int[] currentSizes = new int[3];

  public FixedMultiStack(int totalSize) {
    if (totalSize < 2)
      throw new IllegalArgumentException("Total stack size should not less than 3");
    stack = new int[totalSize];
  }

  public void push(int stackNum, int val) {
    if (isFull(stackNum)) throw new RuntimeException("The stack is full");
    currentSizes[stackNum]++;
    stack[getCurrentIndex(stackNum)] = val;
  }

  public int pop(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    int currentIndex = getCurrentIndex(stackNum);
    currentSizes[stackNum]--;
    return stack[currentIndex];
  }

  private int getCurrentIndex(int stackNum) {
    return currentSizes[stackNum] + 2 * stackNum - 1;
  }

  private int getMaxSize(int stackNum) {
    int averageSize = stack.length / 3;
    int reminder = (stackNum < stack.length % 3) ? 1 : 0;
    return averageSize + reminder;
  }

  public boolean isEmpty(int stackNum) {
    return currentSizes[stackNum] <= 0;
  }

  public boolean isFull(int stackNum) {
    return currentSizes[stackNum] >= getMaxSize(stackNum);
  }
}

class MultiStack {
  int[] values;
  StackInfo[] stacks;

  public MultiStack(int numberOfStacks, int defaultCapacity) {
    values = new int[numberOfStacks * defaultCapacity];
    stacks = new StackInfo[numberOfStacks];
    for (int i = 0; i < numberOfStacks; i++) {
      int start = i * defaultCapacity;
      StackInfo stackInfo = new StackInfo(start);
      stacks[i] = stackInfo;
    }
  }

  public int pop(int stackNum) {
    int val = peek(stackNum);
    values[getStackEndIndex(stackNum)] = 0;
    StackInfo stackInfo = getStackInfo(stackNum);
    stackInfo.decreaseSizeByOne();
    return val;
  }

  public int push(int stackNum, int val) {
    if (getTotalSize() >= values.length) throw new RuntimeException("The stacks are all full!");
    shift(stackNum);
    values[getNextIndex(getStackEndIndex(stackNum))] = val;
    getStackInfo(stackNum).increaseSizeByOne();
    return val;
  }

  public int peek(int stackNum) {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    return values[getStackEndIndex(stackNum)];
  }

  private void shift(int stackNum) {

    int stackEndIndex = getStackEndIndex(stackNum);
    int nextStackNum = (stackNum + 1) % stacks.length;
    StackInfo nextStackInfo = getStackInfo(nextStackNum);
    if (getNextIndex(stackEndIndex) == nextStackInfo.getStartIndex()) {
      shift(nextStackNum);
      int nextStackStartIndex = nextStackInfo.getStartIndex();
      for (int i = getStackEndIndex(nextStackNum); i >= nextStackStartIndex; i--) {
        values[getNextIndex(i)] = values[i];
      }
      values[nextStackStartIndex] = 0;
      getStackInfo(nextStackNum).setStartIndex(getNextIndex(nextStackStartIndex));
    }
  }

  private int getTotalSize() {
    int totalSize = 0;
    for (StackInfo stackInfo : stacks) {
      int size = stackInfo.getSize();
      totalSize += Math.min(1, size);
    }
    return totalSize;
  }

  private int getStackEndIndex(int stackNum) {
    StackInfo stackInfo = getStackInfo(stackNum);
    int start = stackInfo.getStartIndex();
    int size = stackInfo.getSize();
    return (start + size - 1) % values.length;
  }

  public boolean isEmpty(int stackNum) {
    StackInfo stackInfo = stacks[stackNum];
    int size = stackInfo.getSize();
    return size <= 0;
  }

  private StackInfo getStackInfo(int stackNum) {
    return stacks[stackNum];
  }

  private int getNextIndex(int index) {
    return (index + 1) % values.length;
  }
}

class StackInfo {
  private int start;
  private int size;

  public StackInfo(int start) {
    this.start = start;
  }

  public int getStartIndex() {
    return this.start;
  }

  public int getSize() {
    return this.size;
  }

  public void decreaseSizeByOne() {
    this.size--;
  }

  public void increaseSizeByOne() {
    this.size++;
  }

  public void setStartIndex(int startIndex) {
    this.start = startIndex;
  }
}
