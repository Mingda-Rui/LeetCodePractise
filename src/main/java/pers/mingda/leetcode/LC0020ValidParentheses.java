package pers.mingda.leetcode;

import java.util.Stack;

public class LC0020ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char p: s.toCharArray()) {
            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char open = stack.pop();
                if (p != getClose(open))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private char getClose(char open) {
        if (open == '(')
            return ')';
        else if (open == '{')
            return '}';
        else
            return ']';
    }
}
