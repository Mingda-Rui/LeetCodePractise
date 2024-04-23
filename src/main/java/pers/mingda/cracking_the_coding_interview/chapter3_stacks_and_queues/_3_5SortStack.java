package pers.mingda.cracking_the_coding_interview.chapter3_stacks_and_queues;

import java.util.Stack;

/**
 *  3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 *  an additional temproary stack, but you may not copy the elements into any other data structure
 *  (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */

public class _3_5SortStack {

    Stack<Integer> main;
    Stack<Integer> tmp;

    public _3_5SortStack() {
        main = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }

    public int push(int val) {
        while (!main.isEmpty() && main.peek() < val) {
            tmp.push(main.pop());
        }
        main.push(val);
        while (!tmp.isEmpty()) {
            main.push(tmp.pop());
        }
        return val;
    }

    public int pop() {
        return main.pop();
    }

    public int peek() {
        return main.peek();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public void sort(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int val = stack.pop();
            while(!tmp.isEmpty() && tmp.peek() > val) {
                stack.push(tmp.pop());
            }
            tmp.push(val);
        }
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }
}
