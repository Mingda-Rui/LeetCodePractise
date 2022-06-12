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

    public boolean backspaceCompareTwoPointers(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;
        int sBackspaceCount = 0;
        int tBackspaceCount = 0;
        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0 && (s.charAt(sPointer) == '#' || sBackspaceCount != 0)) {
                if (s.charAt(sPointer) == '#')
                    sBackspaceCount++;
                else
                    sBackspaceCount--;
                sPointer--;
            }
            int sCurrent = sPointer >= 0 ? s.charAt(sPointer) : '#';

            while (tPointer >= 0 && (t.charAt(tPointer) == '#' || tBackspaceCount != 0)) {
                if (t.charAt(tPointer) == '#')
                    tBackspaceCount++;
                else
                    tBackspaceCount--;
                tPointer--;
            }
            int tCurrent = tPointer >= 0 ? t.charAt(tPointer) : '#';

            if (sCurrent != tCurrent)
                return false;
            sPointer--;
            tPointer--;
        }
        return sPointer == tPointer;
    }
}
