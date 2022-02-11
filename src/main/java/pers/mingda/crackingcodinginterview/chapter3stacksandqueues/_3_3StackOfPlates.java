package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

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
    private int currentStackIndex = 0;
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

    public int popAt(int index) {
        if (index >= getTotalSize() - 1)
            return pop();
        int val = peekAt(index);
        int stackNumber = (index + 1) / threshold;
        int indexInStack = (index + 1) % threshold;
        if (indexInStack == 0)
            stacks.get(stackNumber - 1).pop();
        shift(stackNumber, indexInStack);
        if (getCurrentStack().isEmpty())
            currentStackIndex--;

        return val;
    }

    public int peekAt(int index) {
        int stackNumber = index / threshold;
        int indexInStack = index % threshold;
        Stack<Integer> stack = stacks.get(stackNumber);
        int stackSize = stack.size();
        int[] tmp = new int[stackSize];
        for (int i = stackSize - 1; i >= indexInStack; i--) {
            tmp[i] = stack.pop();
        }
        for (int i = indexInStack; i < stackSize; i++) {
            stack.push(tmp[i]);
        }
        return tmp[indexInStack];
    }

    private void shift(int startStack, int startIndex) {
        Stack<Integer> stack = stacks.get(startStack);
        int stackSize = stack.size();
        int[] tmp = new int[stackSize];
        for (int i = stackSize - 1; i >= 0; i--) {
            tmp[i] = stack.pop();
        }
        for (int i = 0; i < stackSize - 1; i++) {
            int val = i < startIndex - 1? tmp[i] : tmp[i + 1];
            stack.push(val);
        }
        if (startIndex == 0)
            stacks.get(startStack - 1).push(tmp[0]);
        if (currentStackIndex >= startStack + 1)
            shift(startStack + 1, 0);
    }

    private Stack<Integer> getCurrentStack() {
        return stacks.get(currentStackIndex);
    }

    private int getTotalSize() {
        int currentSize = getCurrentStack().size();
        currentSize += currentStackIndex * threshold;
        return currentSize;
    }
}
