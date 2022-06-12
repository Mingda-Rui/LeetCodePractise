package pers.mingda.leetcode;

import java.util.Stack;

public class LC0844BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        pushStack(sStack, s);
        pushStack(tStack, t);

        if (sStack.size() != tStack.size())
            return false;
        while (!sStack.isEmpty()) {
            if (sStack.pop() != tStack.pop())
                return false;
        }
        return true;
    }

    private void pushStack(Stack<Character> stack, String types) {
        for (int i = 0; i < types.length(); i++) {
            char c = types.charAt(i);
            if (Character.isLetter(c))
                stack.push(c);
            else if (!stack.isEmpty())
                stack.pop();
        }
    }
}
