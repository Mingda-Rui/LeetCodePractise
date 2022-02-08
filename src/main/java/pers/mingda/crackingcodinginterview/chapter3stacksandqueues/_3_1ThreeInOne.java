package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import java.util.EmptyStackException;

/**
 *  3.1 Three in One: Describe how you could use a single array to implement three stacks.
 */

public class _3_1ThreeInOne {

}


class FixedMultiStack {

    private int[] stack;
    private int[] currentSizes = new int[3];

    public FixedMultiStack(int totalSize) {
        if (totalSize < 2)
            throw new IllegalArgumentException("Total stack size should not less than 3");
        stack = new int[totalSize];
    }

    public void push(int stackNum, int val) {
        if (isFull(stackNum))
            throw new RuntimeException("The stack is full");
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
            StackInfo stackInfo = new StackInfo(start, defaultCapacity);
            stacks[i] = stackInfo;
        }
    }

    public int pop(int stackNum) {
        int val = peek(stackNum);
        values[getStackCurrentIndex(stackNum)] = 0;
        StackInfo stackInfo = getStackInfo(stackNum);
        stackInfo.decreaseSizeByOne();
        return val;
    }

    public int push(int stackNum, int val) {
        if (getTotalSize() >= values.length)
            throw new RuntimeException("The stacks are all full!");

        StackInfo stackInfo = getStackInfo(stackNum);

        return 0;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[getStackCurrentIndex(stackNum)];
    }

    private int getTotalSize() {
        int totalSize = 0;
        for (StackInfo stackInfo: stacks) {
            totalSize += stackInfo.getSize();
        }
        return totalSize;
    }

    private boolean checkStackNum(int stackNum) {
        return stackNum < stacks.length;
    }

    private int getStackCurrentIndex(int stackNum) {
        StackInfo stackInfo = getStackInfo(stackNum);
        int start = stackInfo.getStartIndex();
        int size = stackInfo.getSize();
        return (start + size - 1) % values.length;
    }

    public boolean isEmpty(int stackNum) {
        StackInfo stackInfo = stacks[stackNum];
        int size = stackInfo.getSize();
        return size > 0;
    }

    private StackInfo getStackInfo(int stackNum) {
        return stacks[stackNum];
    }
}

class StackInfo {
    private int start;
    private int size;
    private int capacity;

    public StackInfo(int start, int capacity) {
        this.start = start;
        this.capacity = capacity;
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
}
