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

    public int pull(int stackNum) {
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
