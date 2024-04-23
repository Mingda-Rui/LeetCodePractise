package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 *  3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *  Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 *  threshold. Implement a data structure SetOfStacks that mimic this. SetOfStacks should be
 *  composed of several stacks and should create a new stack once the previous one exceeds capacity.
 *  SetOfStacks.push() and SetOfStacks.pop() should behave indentically to a single stack
 *  (that is, pop() should return the same values as it would if there were just a single stack).
 *  FOLLOW UP
 *  Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

public class _3_3StackOfPlates {

}

class SetOfStacks {

    private int threshold;
    protected int currentStackIndex = 0;
    private List<Stack<Integer>> stacks;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
        stacks = new ArrayList<>();
        stacks.add(new Stack<Integer>());
    }

    public int push(int val) {
        if (getCurrentStack().size() == threshold) {
            currentStackIndex++;
            if (stacks.size() <= currentStackIndex) {
                stacks.add(new Stack<Integer>());
            }
        }
        return getCurrentStack().push(val);
    }

    public int pop() {
        Stack<Integer> currentStack = getCurrentStack();
        if (getCurrentStack().isEmpty()) {
            throw new EmptyStackException();
        }
        int val = getCurrentStack().pop();
        if (currentStack.isEmpty()) {
            if (stacks.size() > currentStackIndex + 1) {
                stacks.remove(stacks.size() - 1);
            }
            currentStackIndex = Math.max(currentStackIndex - 1, 0);
        }

        return val;
    }

    protected Stack<Integer> getCurrentStack() {
        return stacks.get(currentStackIndex);
    }

    protected int getThreshold() {
        return this.threshold;
    }

    protected Stack<Integer> getStack(int index) {
        return stacks.get(index);
    }
}

class SetOfStacksShiftPopAt extends SetOfStacks {

    public SetOfStacksShiftPopAt(int threshold) {
        super(threshold);
    }

    public int popAt(int index) {
        if (index >= getTotalSize() - 1)
            return pop();
        int val = peekAt(index);
        int stackNumber = (index + 1) / getThreshold();
        int indexInStack = (index + 1) % getThreshold();
        if (indexInStack == 0)
            getTargetShiftStack(stackNumber, indexInStack, 1).pop();
        shiftByOne(stackNumber, indexInStack);
        if (getCurrentStack().isEmpty())
            currentStackIndex--;

        return val;
    }

    public int peekAt(int index) {
        int stackNumber = index / getThreshold();
        int indexInStack = index % getThreshold();
        return shift(stackNumber, indexInStack, 0);
    }

    private void shiftByOne(int startStack, int startIndex) {
        shift(startStack, startIndex, 1);
        if (currentStackIndex >= startStack + 1)
            shiftByOne(startStack + 1, 0);
    }

    private int shift(int startStack, int startIndex, int shifts) {
        Stack<Integer> stack = getStack(startStack);
        int stackSize = stack.size();
        int[] tmp = new int[stackSize];
        for (int i = stackSize - 1; i >= Math.max(startIndex - shifts, 0); i--) {
            tmp[i] = stack.pop();
        }
        for (int i = startIndex; i < stackSize; i++) {
            Stack<Integer> nextStack = getTargetShiftStack(startStack, i, shifts);
            nextStack.push(tmp[i]);
        }
        return tmp[startIndex];
    }

    private Stack<Integer> getTargetShiftStack(int currentStack, int startIndex, int shifts) {
        int restInStack = getThreshold() - (startIndex + 1);
        int offset = (shifts + restInStack) / getThreshold();
        return getStack(currentStack - offset);
    }

    private int getTotalSize() {
        int currentSize = getCurrentStack().size();
        currentSize += currentStackIndex * getThreshold();
        return currentSize;
    }
}

class SetOfStacksNonShiftPopAt extends SetOfStacks {

    private List<Integer> subStackSizes;
    private int totalSize;

    public SetOfStacksNonShiftPopAt(int threshold) {
        super(threshold);
        this.subStackSizes = new ArrayList<>();
        subStackSizes.add(0);
        this.totalSize = 0;
    }

    @Override
    public int pop() {
        if (totalSize == 0)
            throw new EmptyStackException();
        Stack<Integer> stack = getStack(currentStackIndex);
        int val = stack.pop();
        totalSize--;
        subStackSizes.set(currentStackIndex, stack.size());
        if (stack.isEmpty()) {
            subStackSizes.remove(currentStackIndex);
            currentStackIndex--;
        }
        return val;
    }

    @Override
    public int push(int val) {
        super.push(val);
        totalSize++;
        int stackSize = getStack(currentStackIndex).size();
        if (currentStackIndex == subStackSizes.size())
            subStackSizes.add(0);
        subStackSizes.set(currentStackIndex, stackSize);
        return val;
    }

    public int popAt(int index) {
        if (index >= totalSize)
            throw new IllegalArgumentException("The index exceeds total size, index: " + index);

        int stackNum = getStackNum(index);
        int indexInStack = getIndexInStack(index);
        int stackSize = subStackSizes.get(stackNum);

        int val = remove(stackNum, indexInStack);

        subStackSizes.set(stackNum, stackSize - 1);
        totalSize--;
        if (stackNum == currentStackIndex && stackSize == 0) {
            subStackSizes.remove(stackNum);
            currentStackIndex--;
        }

        return val;
    }

    private int remove(int stackNum, int indexInStack) {
        Stack<Integer> stack = getStack(stackNum);
        int stackSize = stack.size();
        int[] tmp = new int[stackSize];
        for (int i = stackSize - 1; i >= indexInStack; i--) {
            tmp[i] = stack.pop();
        }
        for (int i = indexInStack + 1; i < stackSize; i++) {
            stack.push(tmp[i]);
        }

        return tmp[indexInStack];
    }

    private int getStackNum(int index) {
        int stackIndex = 0;
        for (int i = 0; i < subStackSizes.size() && index >= 0; i++) {
            index -= subStackSizes.get(i);
            stackIndex = i;
        }
        return stackIndex;
    }

    private int getIndexInStack(int index) {
        int stackIndex = index;
        for (int i = 0; i < subStackSizes.size() && index >= 0; i++) {
            stackIndex = index;
            index -= subStackSizes.get(i);
        }
        return stackIndex;
    }
}
