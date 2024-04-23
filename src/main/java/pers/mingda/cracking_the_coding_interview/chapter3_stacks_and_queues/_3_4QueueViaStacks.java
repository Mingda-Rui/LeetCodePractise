package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import java.util.Stack;

/**
 *  3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */

public class _3_4QueueViaStacks {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public _3_4QueueViaStacks() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public int add(int val) {
        in.push(val);
        return val;
    }

    public int remove() {
        if (out.isEmpty())
            shiftStacks();
        return out.pop();
    }

    private void shiftStacks() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
