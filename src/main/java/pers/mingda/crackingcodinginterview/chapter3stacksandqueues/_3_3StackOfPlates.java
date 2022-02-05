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

    private Stack<Integer> getCurrentStack() {
        return stacks.get(currentStackIndex);
    }
}